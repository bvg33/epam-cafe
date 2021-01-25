package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Rating;
import com.epam.web.exceptions.DaoException;

import java.util.Objects;

public class EvaluateOrderService {
    private final DaoHelperFactory daoHelperFactory;

    public EvaluateOrderService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void evaluateOrder(Rating rating) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            Dao dao=daoHelper.createRatingDao();
            dao.save(rating);
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
