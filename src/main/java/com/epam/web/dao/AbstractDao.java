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

public abstract class AbstractDao<T extends Identifiable> extends AbstractQueryExecutor<T> implements Dao<T> {
    private final EntityFieldExtractor<T> fieldExtractor;
    private final String tableName;

    public AbstractDao(ProxyConnection connection, RowMapper<T> rowMapper, EntityFieldExtractor<T> fieldExtractor, String tableName) {
        super(rowMapper,connection);
        this.fieldExtractor = fieldExtractor;
        this.tableName = tableName;
    }

    @Override
    public List<T> getAll() throws DaoException {
        String query = "select * from " + tableName;
        return executeQuery(query);
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

