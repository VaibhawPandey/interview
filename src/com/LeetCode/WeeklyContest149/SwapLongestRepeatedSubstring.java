package com.LeetCode.WeeklyContest149;

import java.util.Scanner;

public class SwapLongestRepeatedSubstring {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text=scanner.next();
        System.out.println(Math.max(maxRepOpt1(text,true),maxRepOpt1(text,false)));
    }
    public static int maxRepOpt1(String text,boolean isBackTracked) {

        int left=0,right=left+1;
        if(!isBackTracked){
            right=text.length()-1;left=right-1;
        }
        int maxCount=0,tempCount=1,diffCount=0;
        String tempText = text;

        while (left<right && right<text.length() && left>=0){

            if(tempText.charAt(left) == tempText.charAt(right) || diffCount == 0){
                if(tempText.charAt(left) != tempText.charAt(right)){
                    diffCount++;
                    if(isBackTracked) {

                        for (int pos = tempText.length() - 1; pos > right; pos--) {
                            if (tempText.charAt(pos) == tempText.charAt(left)) {
                                StringBuilder sb = new StringBuilder(tempText);
                                sb.setCharAt(pos, tempText.charAt(right));
                                sb.setCharAt(right, tempText.charAt(left));
                                tempText = sb.toString();
                                tempCount++;
                                break;
                            }
                        }


                    }else {

                        for (int pos = 0; pos < left; pos++) {
                            if (tempText.charAt(pos) == tempText.charAt(right)) {
                                StringBuilder sb = new StringBuilder(tempText);
                                sb.setCharAt(pos, tempText.charAt(left));
                                sb.setCharAt(left, tempText.charAt(right));
                                tempText = sb.toString();
                                tempCount++;
                                break;
                            }
                        }


                    }
                }
                else
                tempCount++;
                if(isBackTracked)
                right++;
                else
                    left--;
            }else {
                if(isBackTracked) {
                    left++;
                    right = left + 1;
                }else {
                    right--;
                    left = right-1;
                }
                maxCount = Math.max(tempCount,maxCount);
                diffCount = 0;tempCount = 1;
                tempText = text;
            }
        }

        maxCount = Math.max(tempCount,maxCount);

        return maxCount;
    }
}
