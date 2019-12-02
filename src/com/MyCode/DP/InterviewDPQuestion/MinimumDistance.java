package com.MyCode.DP.InterviewDPQuestion;

public class MinimumDistance {

    public static void main(String[] args) {

        int arr[] = {1,6,11,5};
        System.out.println(findMinRec(arr));
    }

    private static int findMinRec(int[] arr) {

        int sum=0,n=arr.length;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        boolean dp[][]=new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 0; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //Excluding
                 dp[i][j] = dp[i-1][j];

                 //Including
                 if(arr[i-1]<=j)
                     dp[i][j] |= dp[i-1][j-arr[i-1]];
            }
        }

        /*for (int i = 0; i <= n; i++) {
            if(i!=0)
            System.out.print(arr[i-1] +" ");
            for (int j = 0; j <= sum; j++) {
                if(i==0)
                    System.out.print(j +" ");
                else
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        int ans=0;
        for (int val = sum/2; val > 0 ; val--) {
             if(dp[n][val]){
                ans = sum - val*2;
                break;
             }
        }

       return ans;
    }
}
