package com.LeetCode.WeeklyContest152;

import java.util.ArrayList;
import java.util.List;

public class PalindromeWithSubstring {

    public static void main(String[] args) {

        int queries[][] ={{1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}};
        List<Boolean> answer = canMakePaliQueries("hunu",queries);
        for (Boolean ans:answer)
            System.out.print(ans +" ");
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> output=new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int left=queries[i][0];
            int right=queries[i][1];
            int k=queries[i][2];

            String subString = s.substring(left,right+1);
            int diff=0;
            int temp=subString.length() - 1;
            boolean isPali=true;
            for (int ch = 0; ch < subString.length(); ch++) {
                if(subString.charAt(ch) != subString.charAt(temp)){
                     if(k>0){
                         String tempSub = subString;
                         subString = subString.substring(0,temp) +subString.charAt(ch);
                         if(temp<tempSub.length()-1)
                             subString += tempSub.substring(temp+1,tempSub.length());
                         k--;
                     }else {
                         isPali = false;
                         output.add(false);
                         break;
                     }
                }
                temp--;
            }

            if(isPali)
            output.add(true);
        }

        return output;
    }
}
