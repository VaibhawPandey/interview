package com.competitiveCodes.VPCodingBlocks.Graph;


import java.util.Arrays;
import java.util.LinkedList;

/*
  * check whether a graph is bipartite or not
  * https://www.geeksforgeeks.org/bipartite-graph/
 */
public class BipartiteGraph {

    final static int V = 4;

    public static void main(String[] args) {

        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        BipartiteGraph biparteGraph=new BipartiteGraph();

        if(biparteGraph.isBiparte(G,0))
            System.out.println("YES");
        else
            System.out.println("No");

    }

    private boolean isBiparte(int[][] G, int src) {

        int graphColor[]=new int[V];
        Arrays.fill(graphColor,-1);

        graphColor[src] = 1;

        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){

            int val=queue.pop();
            //For self loop
            if(G[val][val] == 1)
                return false;

            for (int i = 0; i < V; i++) {

                if(G[val][i] == 1 && graphColor[i] == -1){
                    graphColor[i] = 1-graphColor[val];
                    queue.add(i);
                }else
                    if(G[val][i] == 1 && graphColor[i] == graphColor[val])
                        return false;
            }

        }

        return true;
    }
}
