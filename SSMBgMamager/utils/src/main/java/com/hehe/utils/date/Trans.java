package com.hehe.utils.date;

import com.sun.javafx.binding.StringFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trans {
    public static Date String2Date(String source, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date parseDate = format.parse(source);
        return  parseDate;
    }
    public static String Date2String(Date date,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String formatDate = format.format(date);
        return formatDate;
    }
}
