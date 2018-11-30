package com.lbb.clothes.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    public static Map<String,Long> DateDiff(Date date){
        Map<String,Long> map = new HashMap<>();
        String dateStart = "2018-11-28 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date preDate = null;
        try {
            preDate = format.parse(dateStart);
            long diff = date.getTime() - preDate.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            map.put("day", diffDays);
            map.put("hour", diffHours);
            map.put("min", diffMinutes);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args){
        DateUtil.DateDiff(new Date());
    }
}
