package com.easyjava.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String _YYYYMMDD = "yyyy/MM/dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String date, String pattern){
        try {
            new SimpleDateFormat(pattern).format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
