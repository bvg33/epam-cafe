package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdtodao.OrderDtoDao;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Objects;

public class GoToMyOrdersPageService {
    private final DaoHelperFactory daoHelperFactory;
    public GoToMyOrdersPageService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<OrderDto> getAllUsersOrdersDto(int id) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDtoDao dao=daoHelper.createOrderDtoDao();
            List<OrderDto> result=dao.getUserOrders(id);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(daoHelperFactory);
    }
}
