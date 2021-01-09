package com.epam.web.logic.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class GoToBucketPageService {
    private static final int TIME_TO_MAKE_ORDER=50;
    public Map<String, String> getTime() {
        Calendar calendar = new GregorianCalendar();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        if (hours > 17 || hours < 11) {
            hours = 11;
            minutes = 0;
        }
        String minutesString=null;
        if(minutes<10){
            minutesString="0"+String.valueOf(minutes);
        }
        calendar.add(Calendar.MINUTE,TIME_TO_MAKE_ORDER);
        int minHours=calendar.get(Calendar.HOUR_OF_DAY);
        int minMinutes=calendar.get(Calendar.MINUTE);
        if(minHours>17 || minHours<11){
            minHours=11;
            minMinutes=0;
        }
        String minMinutesString=null;
        if(minMinutes<10){
            minMinutesString="0"+String.valueOf(minMinutes);
        }
        Map<String,String> result=new HashMap<>();
        result.put("hours",String.valueOf(hours));
        result.put("minutes",minutesString);
        result.put("minHours",String.valueOf(minHours));
        result.put("minMinutes",minMinutesString);
        return result;
    }
}
