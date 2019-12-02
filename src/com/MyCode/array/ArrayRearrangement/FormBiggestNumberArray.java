package com.MyCode.array.ArrayRearrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FormBiggestNumberArray {

    public static void main(String[] args) {
        int arr[]={54, 546, 548, 60};

        List<Integer> arrList=new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            arrList.add(arr[i]);

        arrList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1*Math.pow(10,String.valueOf(o2).length()));
                int num1= (int) (o1*Math.pow(10,String.valueOf(o2).length())+o2);
                int num2= (int) (o2*Math.pow(10,String.valueOf(o1).length())+o1);

                System.out.println(o1 +"--" +o2 +"--" +num1 +"--" +num2);

                if(num1<num2)
                    return 1;
                else
                 return -1;
            }
        });

        for (Integer intArr:arrList)
            System.out.print(intArr);
    }
}
