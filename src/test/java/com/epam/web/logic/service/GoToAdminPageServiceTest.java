package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDaoImpl;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class GoToAdminPageServiceTest {
    private void mockDao(DaoHelperFactory daoHelperFactory) throws DaoException, ConnectionException {
        DaoHelper helper= Mockito.mock(DaoHelper.class);
        UserDaoImpl dao=Mockito.mock(UserDaoImpl.class);
        User user=new User(1,"login","password","name","cardNumber",22, Role.USER);
        when(dao.findUsersByRole(anyString())).thenReturn(Arrays.asList(user));
        when(helper.createUserDao()).thenReturn(dao);
        when(daoHelperFactory.createDaoHelper()).thenReturn(helper);
    }
    @Test
    public void testFindUsersShouldReturnUsersWhenDataIsCorrect() throws ConnectionException, DaoException, ServiceException {
        DaoHelperFactory daoHelperFactory=Mockito.mock(DaoHelperFactory.class);
        mockDao(daoHelperFactory);
        GoToAdminPageService service=new GoToAdminPageService(daoHelperFactory);
        List<User>actual=service.findUsers();
        List<User>expected=Arrays.asList(new User(1,"login","password","name","cardNumber",22, Role.USER));
        Assert.assertEquals(expected,actual);
    }
}
