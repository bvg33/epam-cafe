package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class GoToBucketPageServiceTest {
    @Test
    public void testGetTimeShouldReturnMapWhenDataIsCorrect(){
        GregorianCalendar calendar=Mockito.mock(GregorianCalendar.class);
        when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(10);
        when(calendar.get(Calendar.MINUTE)).thenReturn(10);
        when(calendar.get(Calendar.YEAR)).thenReturn(2021);
        GoToBucketPageService service=new GoToBucketPageService();
        Map<String,String> actual=service.getTime(calendar);
        Map<String,String> expected=new HashMap<>();
        expected.put("minDate","2021-01-00T10:10");
        expected.put("maxDate","2021-02-00T10:10");
        Assert.assertEquals(expected,actual);
    }
}
