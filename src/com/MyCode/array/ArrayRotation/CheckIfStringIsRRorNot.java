package com.MyCode.array.ArrayRotation;

public class CheckIfStringIsRRorNot {

    public static void main(String[] args) {
        String a = "ABACD";
        String b = "CDABA";

        System.out.println(isRotation(a,b));
    }

    private static boolean isRotation(String a, String b) {

        int n=a.length(),m=b.length();

        if(n!=m)
            return false;

        int len=0;
        int j=1;

        int lps[]=new int[n];
        lps[0]=0;

        while (j<n){
           if(a.charAt(j) == b.charAt(len)){
               lps[j] = ++len;
               ++j;
           }else {
               if(len == 0){
                   lps[j]=0;
                   ++j;
               }else
                   lps[j] = lps[j-1];
           }
        }

        j=0;
        for (int k=lps[n-1];k< n;k++){
            if(b.charAt(k) != a.charAt(j))
                return false;
            j++;
        }

        return true;


    }
}
