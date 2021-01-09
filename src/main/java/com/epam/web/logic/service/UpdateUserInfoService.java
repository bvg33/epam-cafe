package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.enums.UserInfoResponseEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.CardNumberValidator;
import com.epam.web.logic.validator.LoginValidator;
import com.epam.web.logic.validator.UserNameValidator;

import java.sql.SQLException;
import java.util.Optional;

public class UpdateUserInfoService {
    private DaoHelperFactory daoHelperFactory;

    public UpdateUserInfoService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public UserInfoResponseEnum isUpdatableInfo(String newLogin, String newName, String newCardNumber, int id) throws DaoException {
        UserInfoResponseEnum result =null;
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao=daoHelper.createUserDao();
            Optional<User>userResult=dao.findUserByLogin(newLogin);
            AbstractValidator userNameValidator=new UserNameValidator();
            AbstractValidator loginValidator=new LoginValidator();
            AbstractValidator cardNumberValidator=new CardNumberValidator();
            if(userResult.isPresent()&& userResult.get().getId()!=id){
                result= UserInfoResponseEnum.WRONG_LOGIN;
            } else if(userNameValidator.isValid(newName) && loginValidator.isValid(newLogin)
            && cardNumberValidator.isValid(newCardNumber)){
                result= UserInfoResponseEnum.OK;
            } else {
                result = UserInfoResponseEnum.NOT_VALID_DATA;
            }
        }
        return result;
    }
    public void updateInfo(User newUserInfo) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            dao.save(newUserInfo);
        }
    }
}
