package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderProblemBFS {

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println(getMinMoves(moves,N));
    }

    static class QueueTree{

        int v;
        int dist;

        QueueTree(){}
    }

    private static int getMinMoves(int[] moves, int n) {

        Queue<QueueTree> queue=new LinkedList<>();
        QueueTree queueTree=new QueueTree();
        boolean visited[]=new boolean[n];
        Map<Integer,Integer> parentChildMap=new HashMap<>();

        for (int i = 0; i < n; i++)
            visited[i]=false;

        queueTree.v=0;
        queueTree.dist=0;
        visited[0]=true;
        queue.add(queueTree);

        while (!queue.isEmpty()){

            queueTree=queue.poll();
            //System.out.println("V:-" +queueTree.v);

            if(queueTree.v == n-1)
                break;

            for(int j=queueTree.v+1;j<=(queueTree.v+6) & j<n;j++){

                if(!visited[j]) {
                    QueueTree qT = new QueueTree();
                    qT.dist = queueTree.dist + 1;

                    if (moves[j] != -1) {
                        qT.v = moves[j];
                        parentChildMap.put(qT.v,queueTree.v);
                    }
                    else
                    {
                        qT.v = j;
                        parentChildMap.put(qT.v,queueTree.v);
                    }

                    visited[j]=true;

                    queue.add(qT);
                }

            }

        }

        int i=parentChildMap.get(n-1);
        System.out.print(n-1 +"-->" +i +"-->");

        while (i!=0){
           i=parentChildMap.get(i);
           if(i==0)
           System.out.println(i);
           else
               System.out.print(i +"-->");
        }

        return queueTree.dist;
    }
}
