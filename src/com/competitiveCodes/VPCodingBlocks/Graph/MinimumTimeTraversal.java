package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Scanner;

public class MinimumTimeTraversal {

    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int s[]=new int[2];
            int d[]=new int[2];
            int n=scanner.nextInt();

            s[0]=scanner.nextInt();
            s[1]=scanner.nextInt();
            d[0]=scanner.nextInt();
            d[1]=scanner.nextInt();

            int h[][]=new int[n][5];
            boolean f[]=new boolean[n];

            for (int j = 0; j < n; j++) {

                h[j][0] = scanner.nextInt();
                h[j][1] = scanner.nextInt();
                h[j][2] = scanner.nextInt();
                h[j][3] = scanner.nextInt();
                h[j][4] = scanner.nextInt();
                f[j] = false;
            }

            find_min(s,d,h,n,0,f,false,0);
            System.out.println("#" +i +":" +result);
            result = Integer.MAX_VALUE;
        }

    }

    private static void find_min(int[] s, int[] d, int[][] h, int n, int a, boolean[] f,boolean f1, int time) {

        if(f1){
            time += Math.abs(s[0]-d[0]) + Math.abs(s[1]-d[1]);
            result = Math.min(time,result);
            return;
        }
        if(a==n){
            time += Math.abs(s[0]-d[0]) + Math.abs(s[1]-d[1]);
            result = Math.min(time,result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!f[i]) {

                f[i]=true;
                int t = Math.abs(s[0]-h[i][0]) + Math.abs(s[1]-h[i][1]);
                int b = s[0];
                int c = s[1];
                s[0] = h[i][2];
                s[1] = h[i][3];
                find_min(s,d,h,n,a+1,f,f1,time+t+h[i][4]);
                f[i] = false;
                s[0] = b;
                s[1] = c;


                f[i] = true;
                t = Math.abs(s[0]-h[i][2]) + Math.abs(s[1]-h[i][3]);
                b = s[0];
                c = s[1];
                s[0] = h[i][0];
                s[1] = h[i][1];
                find_min(s,d,h,n,a+1,f,f1,time+t+h[i][4]);
                f[i] = false;
                s[0] = b;
                s[1] = c;

            }
        }

        find_min(s,d,h,n,a+1,f,!f1,time);
        return;
    }
}
