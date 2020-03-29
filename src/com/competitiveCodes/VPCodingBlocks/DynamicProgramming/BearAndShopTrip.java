package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

// import javafx.util.Pair;
import java.util.*;

public class BearAndShopTrip {

    static Double dist[][];
    static Double dp[][];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        //List<Pair<Integer,Integer>> coordinateMap=new ArrayList<>();
        List<Integer> ingredientsMap = new ArrayList<>();
        int noOfElements[] = new int[t];
        int k[]=new int[t];

        for (int i = 0; i < t; i++) {
            //coordinateMap.clear();
            ingredientsMap.clear();

            noOfElements[i]=scanner.nextInt();
            k[i]=scanner.nextInt();

            dist=new Double[noOfElements[i]][noOfElements[i]];
            dp=new Double[(1<<k[i])][noOfElements[i]];
            int All=(1<<k[i]) - 1;
            //coordinateMap.add(new Pair<>(0,0));

            for (int j = 0; j < noOfElements[i]; j++) {
                //coordinateMap.add(new Pair<>(scanner.nextInt(),scanner.nextInt()));
            }

            ingredientsMap.add(0);
            int possible=0;

            for (int j = 0; j < noOfElements[i]; j++) {
                String ingredient=scanner.next();

                int cnt=0;
                int temp_ingredient=0;

                for (int l = ingredient.length()-1; l >=0; l--) {
                    //System.out.println(l);
                   temp_ingredient |= (1<<cnt)*(ingredient.charAt(l)-'0');
                   cnt++;
                }
                possible |= temp_ingredient;
                ingredientsMap.add(temp_ingredient);
            }

            if(possible != All){
                System.out.println(0);
                continue;
            }

            for (int j = 0; j < noOfElements[i]; j++) {
                for (int l = 0; l < noOfElements[i]; l++) {
                    // dist[j][l]=distance(coordinateMap.get(j),coordinateMap.get(l));
                }
            }

            for (int j = 0; j < (1<<k[i]); j++) {
                for (int l = 0; l < noOfElements[i]; l++) {
                    dp[j][l]= Double.valueOf(-1);
                }
            }

            Double ans=shopTrip(0,0,k[i],noOfElements[i],ingredientsMap);

            System.out.println(ans);

        }
    }

    private static Double shopTrip(int mask, int idx,int k,int n,List<Integer> ingredientsMap) {

        if(((1<<k)-1)==mask && idx == 0)
            return 0.0;

        if(dp[mask][idx] != -1)
            return Double.valueOf(dp[mask][idx]);

        dp[mask][idx] = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
             if(((mask|ingredientsMap.get(i))!=mask)||(i==0)){
                 dp[mask][idx] = Math.min(dp[mask][idx],dp[idx][i] + shopTrip((mask|ingredientsMap.get(i)),i,k,n,ingredientsMap));
             }
        }

        return dp[mask][idx];
    }

//    private static double distance(Pair<Integer, Integer> firstPair, Pair<Integer, Integer> secondPair) {
//
//        int dx=firstPair.getKey()-secondPair.getKey();
//        int dy=firstPair.getValue()-secondPair.getValue();
//
//        return Math.sqrt(dx*dx + dy*dy);
//    }
}
