package com.LeetCode.Contest1099;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EarliestAcquatient {

    public static void main(String[] args) {

        int logs[][]={{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int N=6;

        System.out.println(earliestAcq(logs,N));

    }

    public static int earliestAcq(int[][] logs, int N) {

        List<HashSet<Integer>> intSetList=new ArrayList<>();


        for (int i = 0; i < logs.length; i++) {

            boolean doesContain = false;
            for (int j = 0; j < intSetList.size(); j++) {
                if(intSetList.get(j).contains(logs[i][1]) || intSetList.get(j).contains(logs[i][2])){
                    intSetList.get(j).add(logs[i][1]);
                    intSetList.get(j).add(logs[i][1]);
                    doesContain = true;
                }
                if(intSetList.get(j).size()==N)
                    return logs[i][0];

            }

            if(doesContain) {
                HashSet<Integer> newHashSet = new HashSet<>();
                newHashSet.add(logs[i][1]);
                newHashSet.add(logs[i][2]);
                intSetList.add(newHashSet);
            }

        }

        return -1;
    }
}
