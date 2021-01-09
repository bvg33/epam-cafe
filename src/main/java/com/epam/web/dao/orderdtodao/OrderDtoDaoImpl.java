package com.epam.web.dao.orderdtodao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.dto.OrderDto;
import com.epam.web.entity.Bucket;
import com.epam.web.entity.Menu;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class OrderDtoDaoImpl extends AbstractDao<OrderDto> implements OrderDtoDao {
    private static final String GET_BY_ID_QUERY="select * from "+Order.TABLE+" o inner join "+ Bucket.TABLE+" b on o.id=b.order_id inner join "+Menu.TABLE+" m on b.dish_id=m.id "+"inner join "+ User.TABLE+" u on o.user_id=u.id where user_id=? order by time";
    private static final String GET_ALL_QUERY="select * from "+Order.TABLE+" o inner join "+ Bucket.TABLE+" b on o.id=b.order_id inner join "+Menu.TABLE+" m on b.dish_id=m.id inner join "+ User.TABLE+" u on o.user_id=u.id order by time";

    public OrderDtoDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(OrderDto.TABLE), FieldExtractorFactory.createFieldExtractor(Order.TABLE),Order.TABLE);
    }
    @Override
    public List<OrderDto> getUserOrders(int id) throws DaoException {
        return executeQuery(GET_BY_ID_QUERY,id);
    }

    private List<OrderDto> getAllOrders() throws DaoException {
        return executeQuery(GET_ALL_QUERY);
    }

    @Override
    public List<OrderDto> getAll() throws DaoException {
        return this.getAllOrders();
    }
}
