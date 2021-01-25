package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractQueryExecutor <T extends Identifiable> {
    private final RowMapper<T> rowMapper;
    private final ProxyConnection connection;

    public AbstractQueryExecutor(RowMapper<T> rowMapper, ProxyConnection connection) {
        this.rowMapper = rowMapper;
        this.connection = connection;
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
}
