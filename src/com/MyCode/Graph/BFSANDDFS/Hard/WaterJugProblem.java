package com.MyCode.Graph.BFSANDDFS.Hard;

import javafx.util.Pair;

import java.util.*;

/**
 * Ref:- https://www.geeksforgeeks.org/water-jug-problem-using-bfs/
 */
public class WaterJugProblem {

    public static void main(String[] args) {
        int jug1=4,jug2=3,d=2;

        BFS(jug1,jug2,d);
    }

    private static void BFS(int a, int b, int target) {

        List<Pair<Integer,Integer>> path=new ArrayList<>();
        Map<Pair<Integer,Integer>,Integer> map=new HashMap<>();
        boolean isSolvable = false;

        Queue<Pair<Integer,Integer>> queue=new ArrayDeque<>();
        queue.add(new Pair<>(0, 0));

        while (!queue.isEmpty()){
            Pair<Integer,Integer> tempPair=queue.poll();

            if(map.containsKey(new Pair<>(tempPair.getKey(),tempPair.getValue())) && map.get(new Pair<>(tempPair.getKey(),tempPair.getValue())) == 1)
                continue;

            if(tempPair.getKey()>a || tempPair.getValue()>b || tempPair.getKey()<0 || tempPair.getValue()<0)
                continue;

            map.put(new Pair<>(tempPair.getKey(),tempPair.getValue()),1);
            path.add(tempPair);

            if(tempPair.getKey() == target || tempPair.getValue() == target){
                isSolvable = true;
                if(tempPair.getKey() == target && tempPair.getValue() != 0)
                    path.add(new Pair<>(tempPair.getKey(),0));
                else if(tempPair.getKey() != 0 && tempPair.getValue() == target)
                    path.add(new Pair<>(0,tempPair.getValue()));

                for (int i = 0; i < path.size(); i++)
                    System.out.print("(" +path.get(i).getKey() +"--" +path.get(i).getValue() +")" +" --> " );

                break;
            }

            queue.add(new Pair<>(tempPair.getKey(),b));
            queue.add(new Pair<>(a,tempPair.getValue()));

            for (int i = 0; i < Math.max(a, b); i++) {

                  int c = tempPair.getKey() + i;
                  int d = tempPair.getValue() - i;

                  if((c == a && d>=0) || d==0)
                      queue.add(new Pair<>(c,d));

                  c= tempPair.getKey() - i;
                  d= tempPair.getValue() + i;

                  if(c==0 || (d== b && c>=0))
                      queue.add(new Pair<>(c,d));

            }

            queue.add(new Pair<>(a,0));
            queue.add(new Pair<>(0,b));
        }

        if(!isSolvable)
            System.out.println("No solution");
    }
}
