package com.general;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FormattedDate {
    public static void main(String[] args) {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
        String dateStr = "2023-02-15 03:33:01.957";
        String subString = dateStr.substring(0, 16);
        String first =  subString.split(" ")[0];
        String second =  subString.split(" ")[1];
        System.out.println(first+"-"+second.replace(":", "-"));
    }
}

//2023-02-15-03-33-01