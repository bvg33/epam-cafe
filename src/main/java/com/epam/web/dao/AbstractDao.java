package com.epam.web.dao;

import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
    private final Connection connection;
    private final RowMapper<T> rowMapper;

    public AbstractDao(Connection connection, RowMapper<T> rowMapper) {
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
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
                return entities;
            }
        } catch (SQLException e) {
            throw new DaoException("Execute query exception ", e);
        }
        return entities;
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new DaoException("Prepare Statement exception");
        }
    }

    @Override
    public List<T> getAll() {
        return null;
    }

}

