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

    public int createNextOrderNumber() throws ServiceException {
        int id;
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            OrderDao dao = daoHelper.createOrderDao();
            ArrayList<Order> orders = (ArrayList<Order>) dao.getAll();
            if(orders.isEmpty()){
                return 1;
            }
            id = orders.get(orders.size()-1).getId()+1;
        }catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return id;
    }

    public void takeOrder(ArrayList<Bucket> buckets, Order order) throws ServiceException{
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
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
                    throw new ServiceException(ex.getMessage(), ex);
                }
                throw new ServiceException(e.getMessage(), e);
            } finally {
                try {
                    daoHelper.endTransaction();
                } catch (ConnectionException e) {
                    e.printStackTrace();
                }
            }
        } catch (ConnectionException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    public boolean isValidCVC(String cvc, AbstractValidator validator) {
        return validator.isValid(cvc);
    }
}
