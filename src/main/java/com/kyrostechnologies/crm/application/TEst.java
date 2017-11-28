package com.kyrostechnologies.crm.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TEst {
    public static void main(String[] args) throws ParseException {
        String myDate = "2017-11-28 06:54 AM";
        String currentDate=currentTime();
        long milliBackend=toMilliseconds(myDate);
        long milliCurrent=toMilliseconds(currentDate);

//        System.out.println("Milli Second : "+milli);
//        String date=toDate(milli);
//        System.out.println("Date : "+date);
        difference(milliCurrent,milliBackend);




    }
    private static String currentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        Date date = new Date();
        return dateFormat.format(date);
    }
    private static void difference(long currentMilliSecond,long backEndMilliSecond){
        Date d2 = new Date(currentMilliSecond);
        Date d1 = new Date(backEndMilliSecond);

        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        int diffInDays = (int) diff / (1000 * 60 * 60 * 24);

        System.out.println(diffInDays+"  days");
        System.out.println(diffHours+"  Hour");
        System.out.println(diffMinutes+"  min");
        System.out.println(diffSeconds+"  sec");
    }
    private static String toDate(long milliSeconds){

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
    private static long toMilliseconds(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        Date dsate = sdf.parse(date);
       return dsate.getTime();
    }

}
