package com.epam.web.dao.orderdtodao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractQueryExecutor;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.dto.OrderDto;
import com.epam.web.entity.*;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public class OrderDtoDaoImpl extends AbstractQueryExecutor<OrderDto> implements OrderDtoDao {
    private static final String GET_BY_ID_QUERY="select * from "+Order.TABLE+" o inner join "+ Bucket.TABLE+" b on o.id=b.order_id inner join "+Menu.TABLE+" m on b.dish_id=m.id "+"inner join "+ User.TABLE+" u on o.user_id=u.id left join "+ Rating.TABLE+
    " r on o.id=r.order_id where user_id=? order by time";
    private static final String GET_ALL_UNCOLLECTED_QUERY="select * from "+Order.TABLE+" o inner join "+ Bucket.TABLE+" b on o.id=b.order_id inner join "+Menu.TABLE+" m on b.dish_id=m.id inner join "+ User.TABLE+" u on o.user_id=u.id left join "+Rating.TABLE+" r on o.id=r.order_id where state!='picked_up' order by time";
    private static final String GET_ALL_COLLECTED_QUERY="select * from "+Order.TABLE+" o inner join "+ Bucket.TABLE+" b on o.id=b.order_id inner join "+Menu.TABLE+" m on b.dish_id=m.id inner join "+ User.TABLE+" u on o.user_id=u.id left join "+Rating.TABLE+" r on o.id=r.order_id where state='picked_up' order by time";
    public OrderDtoDaoImpl(ProxyConnection connection) {
        super(RowMapperFactory.createMapper(OrderDto.NAME),connection);
    }
    @Override
    public List<OrderDto> getUserOrders(int id) throws DaoException {
        return executeQuery(GET_BY_ID_QUERY,id);
    }

    @Override
    public List<OrderDto> getAllUncollectedOrders() throws DaoException {
        return executeQuery(GET_ALL_UNCOLLECTED_QUERY);
    }

    @Override
    public List<OrderDto> getAllCollectedOrders() throws DaoException {
        return executeQuery(GET_ALL_COLLECTED_QUERY);
    }
}
