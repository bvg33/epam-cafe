package com.epam.web.logic.service;

import java.util.*;

public class GoToBucketPageService {
    private static final int TIME_TO_MAKE_ORDER=50;
    public Map<String, String> getTime(Calendar calendar) {
        String minDate=createTimeDate(calendar,1);
        String maxDate=createTimeDate(calendar,2);
        Map<String,String> result=new HashMap<>();
        result.put("minDate",minDate);
        result.put("maxDate",maxDate);
        return result;
    }

    private String createTimeDate(Calendar calendar,int monthDifference){
        calendar.add(Calendar.MINUTE,TIME_TO_MAKE_ORDER);
        int minHours=calendar.get(Calendar.HOUR_OF_DAY);
        int minMinutes=calendar.get(Calendar.MINUTE);
        String minHoursString=String.valueOf(minHours);
        String minMinutesString=String.valueOf(minMinutes);
        if(minHours<10){
            minHoursString="0"+minHoursString;
        }
        if(minMinutes<10){
            minMinutesString="0"+minMinutesString;
        }
        return createDate(calendar,monthDifference)+"T"+minHoursString+":"+minMinutesString;
    }

    private String createDate(Calendar calendar,int monthDifference){
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+monthDifference;
        int chislo=calendar.get(Calendar.DAY_OF_MONTH);
        String stringMonth=String.valueOf(month),stringChislo=String.valueOf(chislo);
        if(month<10){
            stringMonth="0"+stringMonth;
        }
        if(chislo<10){
            stringChislo="0"+stringChislo;
        }
        return year +"-"+stringMonth+"-"+stringChislo;
    }
}
