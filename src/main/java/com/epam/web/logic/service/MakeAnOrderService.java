package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdao.OrderDao;
import com.epam.web.entity.Bucket;
import com.epam.web.entity.Order;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.CVCValidator;

import java.util.ArrayList;
import java.util.Objects;

public class MakeAnOrderService {
    private final DaoHelperFactory daoHelperFactory;

    public MakeAnOrderService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public int createNextOrderNumber() throws DaoException {
        int id;
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            OrderDao dao = daoHelper.createOrderDao();
            ArrayList<Order> orders = (ArrayList<Order>) dao.getAll();
            if(orders.isEmpty()){
                return 1;
            }
            id = orders.get(orders.size()-1).getId()+1;
        }
        return id;
    }

    public void takeOrder(ArrayList<Bucket> buckets, Order order) throws ServiceException {
        DaoHelper daoHelper = daoHelperFactory.createDaoHelper();
        try {
            daoHelper.startTransaction();
            OrderDao orderDao = daoHelper.createOrderDao();
            Dao bucketDao = daoHelper.createBucketDao();
            orderDao.save(order);
            for (Bucket bucket : buckets) {
                bucketDao.save(bucket);
            }
            daoHelper.commit();
        } catch (ConnectionException | DaoException e) {
            try {
                daoHelper.rollBack();
            } catch (ConnectionException ex) {
                throw new ServiceException("RollBack exception",ex);
            }
            throw new ServiceException(e.getMessage(),e);
        }finally {
            try {
                daoHelper.endTransaction();
                daoHelper.close();
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isValidCVC(String cvc, AbstractValidator validator) {
        return validator.isValid(cvc);
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
