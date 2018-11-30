package com.lbb.clothes.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String DateDiff(Date date){
        String dateStart = "2018-11-28 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date preDate = null;
        String str="";
        try {
            preDate = format.parse(dateStart);
            long diff = date.getTime() - preDate.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            str = diffDays+"天"+diffHours+"小时"+diffMinutes+"分钟";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args){
        DateUtil.DateDiff(new Date());
    }
}
