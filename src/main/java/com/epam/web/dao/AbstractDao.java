package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.extractor.EntityFieldExtractor;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.dao.querycreator.QueryCreator;
import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
    private final ProxyConnection connection;
    private final RowMapper<T> rowMapper;
    private final EntityFieldExtractor<T> fieldExtractor;
    private final String tableName;

    public AbstractDao(ProxyConnection connection, RowMapper<T> rowMapper, EntityFieldExtractor<T> fieldExtractor, String tableName) {
        this.connection = connection;
        this.rowMapper = rowMapper;
        this.fieldExtractor = fieldExtractor;
        this.tableName = tableName;
    }

    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        } else if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More then one record found");
        }
        return Optional.empty();
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> entities = new ArrayList<>();
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {
            throw new DaoException("Execute query exception ", e);
        }
        return entities;
    }

    protected void executeUpdate(String query, Object... params) throws DaoException {
        try {
            try (PreparedStatement statement = createStatement(query, params)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new DaoException("Prepare Statement exception", e);
        }
    }

    @Override
    public List<T> getAll() throws DaoException {
        String query = "select * from " + tableName;
        List<T> entities = new ArrayList<>();
        try (PreparedStatement statement = createStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException | DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

    private List<T> createEntitiesList(ResultSet resultSet) throws DaoException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException | DaoException e) {
            throw new DaoException("create Entities List Exception");
        }
        return entities;
    }

    @Override
    public Optional<T> getById(int id) throws DaoException {
        String query = "select * from " + tableName + " where id=?";
        return executeForSingleResult(query, id);
    }

    @Override
    public void save(T item) throws DaoException {
        int id = item.getId();
        Map<String, String> fields = fieldExtractor.parse(item);
        QueryCreator creator = new QueryCreator();
        String query = null;
        if (id == 0) {
            query = creator.createInsertQuery(tableName, fields);
        } else {
            query = creator.createUpdateQuery(tableName, fields);
        }
        List<String> values = new ArrayList<>();
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if (entry.getKey().equals("id") == false) {
                values.add(entry.getValue());
            }
        }
        executeUpdate(query, values.toArray());
    }

    @Override
    public void removeById(Long id) throws DaoException {
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id=?";
        executeUpdate(deleteQuery, id);
    }
}

