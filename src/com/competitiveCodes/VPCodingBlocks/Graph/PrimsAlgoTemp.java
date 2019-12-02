package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

public class PrimsAlgoTemp {

    class Edge implements Comparable<Edge>{

        int src,dest,weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight-compareEdge.weight;
        }
    }

    class subset {
        int parent,rank;
    }

    int V=5;

    private void primsAlgo(int[][] graph) {

        boolean mstSet[]=new boolean[V];
        int key[]=new int[V];
        int parent[]=new int[V];

        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstSet,false);

        key[0]=0;
        parent[0]=-1;

        for (int count = 0; count < V-1; count++) {

            int u= minKey(key,mstSet);

            mstSet[u]=true;

            for (int v = 0; v < V; v++) {

                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < V; i++)
            System.out.println(parent[i] +"--" +i +"--" +key[i]);

    }

    private int minKey(int[] key, boolean[] mstSet) {

        int min_value=Integer.MAX_VALUE,min_position=-1;

        for (int v = 0; v < V; v++) {

            if(mstSet[v] == false && key[v] < min_value){
                min_value=key[v];
                min_position=v;
            }
        }

        return min_position;

    }


    public static void main(String[] args) {

        PrimsAlgoTemp primsAlgoTemp=new PrimsAlgoTemp();

        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        primsAlgoTemp.primsAlgo(graph);
    }




}
