package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.enums.UserInfoResponseEnum;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.CardNumberValidator;
import com.epam.web.logic.validator.LoginValidator;
import com.epam.web.logic.validator.UserNameValidator;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class UpdateUserInfoService {
    private DaoHelperFactory daoHelperFactory;

    public UpdateUserInfoService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public UserInfoResponseEnum isUpdatableInfo(String newLogin, String newName, String newCardNumber, int id,
                                                UserNameValidator userNameValidator, LoginValidator loginValidator,
                                                CardNumberValidator cardNumberValidator) throws ServiceException {
        UserInfoResponseEnum result = null;
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            Optional<User> userResult = null;
            try {
                userResult = dao.findUserByLogin(newLogin);
            } catch (DaoException e) {
                throw new ServiceException(e.getMessage(), e);
            }
            if ((userResult.isPresent() && userResult.get().getId() != id) || !loginValidator.isValid(newLogin)) {
                result = UserInfoResponseEnum.WRONG_LOGIN;
            } else if (!userNameValidator.isValid(newName)) {
                result = UserInfoResponseEnum.WRONG_NAME;
            } else if (!cardNumberValidator.isValid(newCardNumber)) {
                result = UserInfoResponseEnum.WRONG_CARD_NUMBER;
            } else {
                result = UserInfoResponseEnum.OK;
            }
        } catch (ConnectionException e) {
            throw new ServiceException(e.getMessage(),e);
        }
        return result;
    }

    public void updateInfo(User newUserInfo) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            dao.save(newUserInfo);
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
