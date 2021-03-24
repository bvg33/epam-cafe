package com.epam.web.logic.service;

import java.util.*;

public class GoToBucketPageService {
    private static final int TIME_TO_MAKE_ORDER=30;
    private static final String MIN_DATE="minDate";
    private static final String MAX_DATE="maxDate";
    private static final String ZERO="0";
    private static final String TIME_DATE_SEPARATOR="T";
    private static final String TIME_SEPARATOR=":";
    private static final String DATE_SEPARATOR="-";

    public Map<String, String> getTime(Calendar calendar) {
        String minDate=createTimeDate(calendar,1);
        String maxDate=createTimeDate(calendar,2);
        Map<String,String> result=new HashMap<>();
        result.put(MIN_DATE,minDate);
        result.put(MAX_DATE,maxDate);
        return result;
    }

    private String createTimeDate(Calendar calendar,int monthDifference){
        calendar.add(Calendar.MINUTE,TIME_TO_MAKE_ORDER);
        int minHours=calendar.get(Calendar.HOUR_OF_DAY);
        int minMinutes=calendar.get(Calendar.MINUTE);
        String minHoursString=String.valueOf(minHours);
        String minMinutesString=String.valueOf(minMinutes);
        if(minHours<10){
            minHoursString=ZERO+minHoursString;
        }
        if(minMinutes<10){
            minMinutesString=ZERO+minMinutesString;
        }
        return createDate(calendar,monthDifference)+TIME_DATE_SEPARATOR+minHoursString+TIME_SEPARATOR+minMinutesString;
    }

    private String createDate(Calendar calendar,int monthDifference){
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+monthDifference;
        int chislo=calendar.get(Calendar.DAY_OF_MONTH);
        String stringMonth=String.valueOf(month),stringChislo=String.valueOf(chislo);
        if(month<10){
            stringMonth=ZERO+stringMonth;
        }
        if(chislo<10){
            stringChislo=ZERO+stringChislo;
        }
        return year +DATE_SEPARATOR+stringMonth+DATE_SEPARATOR+stringChislo;
    }
}
