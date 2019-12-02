package com.competitiveCodes.techgig;

import java.util.*;

public class WinorLose {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int t=scanner.nextInt();
        int n[]=new int[t];
        List<List<Integer>> villianStrengthList=new ArrayList<>();
        List<List<Integer>> playersPowerList=new ArrayList<>();


        for (int i = 0; i < t; i++) {
            n[i]=scanner.nextInt();
            List<Integer> arrList=new ArrayList<>();
            for (int j = 0; j < n[i]; j++) {
                arrList.add(scanner.nextInt());
            }
            villianStrengthList.add(arrList);
            arrList=new ArrayList<>();
            for (int j = 0; j < n[i]; j++) {
                arrList.add(scanner.nextInt());
            }
            playersPowerList.add(arrList);
        }

        for (int i = 0; i < t; i++)
        System.out.println(getResult(villianStrengthList.get(i),playersPowerList.get(i)));


    }

    private static String getResult(List<Integer> villianStrength, List<Integer> playersPower) {

        Collections.sort(villianStrength);
        Collections.sort(playersPower);

        String result="WIN";

        for (int i = 0; i < villianStrength.size(); i++) {
            if(playersPower.get(i)<=villianStrength.get(i)){
                return "LOSE";
            }
        }

        return result;
    }
}
