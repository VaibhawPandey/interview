package com.LeetCode.WeeklyContest151;

import java.util.*;

public class InvalidTransaction {

    public static void main(String[] args) {
        String transaction[]={"bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"};
        List<String> tr=invalidTransactions(transaction);
        for (int i = 0; i < tr.size(); i++)
            System.out.println(tr.get(i));


    }

    public static List<String> invalidTransactions(String[] transactions) {

        List<String> output=new ArrayList<>();
        HashSet<Integer> positionSet=new HashSet<>();

        String mainSplit[]=transactions[0].split(",");
        if(Integer.valueOf(mainSplit[2])>1000)
            positionSet.add(0);



        for (int i = 0; i < transactions.length; i++) {
            for (int j = i+1; j < transactions.length; j++) {
                String trSplit[]=transactions[j].split(",");
                String ftSplit[]=transactions[i].split(",");

                if(Integer.valueOf(trSplit[2])>1000) {
                    positionSet.add(j);
                    //continue;
                }
                    int timeDiff = Math.abs(Integer.valueOf(ftSplit[1]) - Integer.valueOf(trSplit[1]));
                    if (timeDiff <= 60 && ftSplit[0].equalsIgnoreCase(trSplit[0]) && !ftSplit[3].equalsIgnoreCase(trSplit[3])) {
                        positionSet.add(i);
                        positionSet.add(j);
                    }

            }
        }

        for (Integer position:positionSet){
            output.add(transactions[position]);
        }

        return output;
    }
}
