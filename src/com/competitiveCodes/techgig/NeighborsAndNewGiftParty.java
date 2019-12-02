package com.competitiveCodes.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeighborsAndNewGiftParty {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int n[]=new int[t];
        List<List<Integer>> arrList=new ArrayList<>();

        for (int i = 0; i < t; i++) {
            n[i]=scanner.nextInt();
            List<Integer> arr=new ArrayList<>();
            for (int j = 0; j < n[i]; j++) {
                arr.add(scanner.nextInt());
            }
            arrList.add(arr);
        }

        for (int i = 0; i < t; i++)
            System.out.println(getResult1(arrList.get(i)));
    }

    private static String getResult2(List<Integer> arr){
        String result="";
        long best=Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            long current_value =0;
            String result_new="";
            for (int j = i; j < arr.size(); j=j+2) {
                if(i==j || current_value+arr.get(j) > current_value) {
                    current_value += arr.get(j);
                    result_new = arr.get(j) +"," + result_new;
                }
            }

            if(current_value==best){
                if (Integer.valueOf(result.split(",")[0]) < Integer.valueOf(result_new.split(",")[0]))
                        result = result_new;
                }

            if(current_value>best){
                best=current_value;
                result = result_new;
            }
        }

        result=result.replaceAll(",","");


        return result;

    }

    private static String getResult1(List<Integer> arr) {

        String result="";

        long incl=arr.get(0),excl=Integer.MIN_VALUE,excl_new;
        String incl_path=arr.get(0) +",",excl_path="",excl_new_path;

        for (int i = 1; i < arr.size(); i++) {
            if(incl>excl){
                excl_new=incl;
                excl_new_path=incl_path +",";
            }else {
                excl_new=excl;
                excl_new_path=excl_path +",";
            }

            if(excl + arr.get(i)<arr.get(i)){
                incl = arr.get(i);
                incl_path = "" +arr.get(i) +",";
            }else {
                incl = excl + arr.get(i);
                incl_path = arr.get(i) +"," +excl_path;
            }
            excl=excl_new;
            excl_path=excl_new_path;
        }

        if(incl==excl){
            if(Integer.valueOf(incl_path.split(",")[0])>Integer.valueOf(excl_path.split(",")[0]))
                result=incl_path.replaceAll(",","");
            else
                result=excl_path.replaceAll(",","");
        }
        else
        if(incl>excl){
            result=incl_path.replaceAll(",","");;
        }else {
            result=excl_path.replaceAll(",","");
        }

        return result;
    }
}
