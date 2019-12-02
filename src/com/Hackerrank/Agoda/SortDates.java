package com.Hackerrank.Agoda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortDates {
    public static void main(String[] args) {
        List<String> dates=new ArrayList<>();
        dates.add("01 Mar 2017");
        dates.add("03 Feb 2017");
        List<String> outDate=sortDates(dates);
        for (String outD:outDate)
            System.out.println(outD);
    }

    private static List<String> sortDates(List<String> dates) {

        List<String> output=new ArrayList<>();
        DateFormat format=new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        List<Date> dateList=new ArrayList<>();
        Map<Long,String> map=new HashMap<>();
        for (String date:dates)
            try {
                Date d=format.parse(date);
                dateList.add(d);
                map.put(d.getTime(),date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        Collections.sort(dateList, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                if(o1.getTime()>o2.getTime())
                    return 1;
                else
                    return -1;
            }
        });

        for (Date date:dateList){
            output.add(map.get(date.getTime()));
        }


        return output;
    }


}
