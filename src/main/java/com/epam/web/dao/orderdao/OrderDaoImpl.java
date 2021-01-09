package com.epam.web.dao.orderdao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.EntityFieldExtractor;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String GET_QUERY="select * from "+Order.TABLE+" where user_id=?";
    public OrderDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Order.TABLE), FieldExtractorFactory.createFieldExtractor(Order.TABLE),Order.TABLE);
    }

    @Override
    public List<Order> getUsersOrders(int userId) throws DaoException {
        return executeQuery(GET_QUERY,userId);
    }
}
