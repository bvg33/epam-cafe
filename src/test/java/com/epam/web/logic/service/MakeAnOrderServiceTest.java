package com.epam.web.logic.service;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.validator.CVCValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Calendar;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class MakeAnOrderServiceTest {

    @Test
    public void testIsValidCVCShouldReturnTrueWhenCVCIsValid(){
        CVCValidator validator= Mockito.mock(CVCValidator.class);
        when(validator.isValid(anyString())).thenReturn(true);
        MakeAnOrderService service=new MakeAnOrderService(new DaoHelperFactory());
        boolean actual=service.isValidCVC("123",validator);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidCVCShouldReturnFalseWhenCVCIsNotValid(){
        CVCValidator validator= Mockito.mock(CVCValidator.class);
        when(validator.isValid(anyString())).thenReturn(false);
        MakeAnOrderService service=new MakeAnOrderService(new DaoHelperFactory());
        boolean actual=service.isValidCVC("12",validator);
        Assert.assertEquals(false,actual);
    }
}
