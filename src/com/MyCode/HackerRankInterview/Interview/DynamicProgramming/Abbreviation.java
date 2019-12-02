package com.MyCode.HackerRankInterview.Interview.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        int m=a.length(),n=b.length();
        boolean vector[][]=new boolean[m+1][n+1];

        vector[0][0] = true;

        boolean containsLowerCase=false;

        for (int i = 1; i <= m; i++) {

            if((int)a.charAt(i-1)>=65 && (int) a.charAt(i-1) <= 90|| containsLowerCase){
                containsLowerCase=true;
                vector[i][0]=false;
            }else
                vector[i][0]=true;

        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if(a.charAt(i-1)==b.charAt(j-1)){
                    vector[i][j]=vector[i-1][j-1];
                    continue;
                }else if((int)a.charAt(i-1)-32==(int)b.charAt(j-1)){
                    vector[i][j]=vector[i-1][j]||vector[i-1][j-1];
                    continue;
                }else if(a.charAt(i-1)>=65 && a.charAt(i-1)<=90){
                    vector[i][j]=false;
                    continue;
                }else {
                    vector[i][j]=vector[i-1][j];
                    continue;
                }
            }
        }

        if(vector[m][n]) return "YES";

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            System.out.println(result);

        }



        scanner.close();
    }

}
