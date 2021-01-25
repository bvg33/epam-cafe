package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dao.userdao.UserDaoImpl;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.enums.UserInfoResponseEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.logic.validator.CardNumberValidator;
import com.epam.web.logic.validator.LoginValidator;
import com.epam.web.logic.validator.UserNameValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class UpdateUserInfoServiceTest {
    @Test
    public void testIsUpdatableInfoShouldReturnOKWhenDataIsValid() throws DaoException {
        UserNameValidator userNameValidator= Mockito.mock(UserNameValidator.class);
        when(userNameValidator.isValid(anyString())).thenReturn(true);
        LoginValidator loginValidator= Mockito.mock(LoginValidator.class);
        when(loginValidator.isValid(anyString())).thenReturn(true);
        CardNumberValidator cardNumberValidator=Mockito.mock(CardNumberValidator.class);
        when(cardNumberValidator.isValid(anyString())).thenReturn(true);
        DaoHelperFactory daoHelperFactory=Mockito.mock(DaoHelperFactory.class);
        mockDao(daoHelperFactory);
        UpdateUserInfoService service=new UpdateUserInfoService(daoHelperFactory);
        UserInfoResponseEnum actual =service.isUpdatableInfo("login","Name","cardNumber",1,userNameValidator,
                loginValidator,cardNumberValidator);
        Assert.assertEquals(UserInfoResponseEnum.OK,actual);

    }

    @Test
    public void testIsUpdatableInfoShouldReturnWrongLoginWhenLoginIsNotValid() throws DaoException {
        UserNameValidator userNameValidator= Mockito.mock(UserNameValidator.class);
        when(userNameValidator.isValid(anyString())).thenReturn(true);
        LoginValidator loginValidator= Mockito.mock(LoginValidator.class);
        when(loginValidator.isValid(anyString())).thenReturn(false);
        CardNumberValidator cardNumberValidator=Mockito.mock(CardNumberValidator.class);
        when(cardNumberValidator.isValid(anyString())).thenReturn(true);
        DaoHelperFactory daoHelperFactory=Mockito.mock(DaoHelperFactory.class);
        mockDao(daoHelperFactory);
        UpdateUserInfoService service=new UpdateUserInfoService(daoHelperFactory);
        UserInfoResponseEnum actual =service.isUpdatableInfo("login","Name","cardNumber",1,userNameValidator,
                loginValidator,cardNumberValidator);
        Assert.assertEquals(UserInfoResponseEnum.WRONG_LOGIN,actual);

    }

    @Test
    public void testIsUpdatableInfoShouldReturnWrongNameWhenNameIsNotValid() throws DaoException {
        UserNameValidator userNameValidator= Mockito.mock(UserNameValidator.class);
        when(userNameValidator.isValid(anyString())).thenReturn(false);
        LoginValidator loginValidator= Mockito.mock(LoginValidator.class);
        when(loginValidator.isValid(anyString())).thenReturn(true);
        CardNumberValidator cardNumberValidator=Mockito.mock(CardNumberValidator.class);
        when(cardNumberValidator.isValid(anyString())).thenReturn(true);
        DaoHelperFactory daoHelperFactory=Mockito.mock(DaoHelperFactory.class);
        mockDao(daoHelperFactory);
        UpdateUserInfoService service=new UpdateUserInfoService(daoHelperFactory);
        UserInfoResponseEnum actual =service.isUpdatableInfo("login","Name","cardNumber",1,userNameValidator,
                loginValidator,cardNumberValidator);
        Assert.assertEquals(UserInfoResponseEnum.WRONG_NAME,actual);

    }

    @Test
    public void testIsUpdatableInfoShouldReturnWrongCardNumberWhenCardNumberIsNotValid() throws DaoException {
        UserNameValidator userNameValidator= Mockito.mock(UserNameValidator.class);
        when(userNameValidator.isValid(anyString())).thenReturn(true);
        LoginValidator loginValidator= Mockito.mock(LoginValidator.class);
        when(loginValidator.isValid(anyString())).thenReturn(true);
        CardNumberValidator cardNumberValidator=Mockito.mock(CardNumberValidator.class);
        when(cardNumberValidator.isValid(anyString())).thenReturn(false);
        DaoHelperFactory daoHelperFactory=Mockito.mock(DaoHelperFactory.class);
        mockDao(daoHelperFactory);
        UpdateUserInfoService service=new UpdateUserInfoService(daoHelperFactory);
        UserInfoResponseEnum actual =service.isUpdatableInfo("login","Name","cardNumber",1,userNameValidator,
                loginValidator,cardNumberValidator);
        Assert.assertEquals(UserInfoResponseEnum.WRONG_CARD_NUMBER,actual);

    }

    private void mockDao(DaoHelperFactory daoHelperFactory) throws DaoException {
        DaoHelper helper=Mockito.mock(DaoHelper.class);
        UserDaoImpl dao=Mockito.mock(UserDaoImpl.class);
        User user=new User(1,"login","password","name","cardNumber",22, Role.USER);
        when(dao.findUserByLogin(anyString())).thenReturn(java.util.Optional.of(user));
        when(helper.createUserDao()).thenReturn(dao);
        when(daoHelperFactory.createDaoHelper()).thenReturn(helper);
    }
}
