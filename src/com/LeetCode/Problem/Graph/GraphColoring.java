package com.LeetCode.Problem.Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphColoring {

    static int V;
    static LinkedList<Integer> adj[];

    static void Graph(int v){
        V=v;
        adj=new LinkedList[V+1];
        for (int i = 1; i <= V; i++)
            adj[i] = new LinkedList<>();
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int paths[][] = {{1,2},{3,4}};
        int output[]=gardenNoAdj(n,paths);
        for (int i = 0; i < output.length; i++)
            System.out.print(output[i] +" ");

    }

    public static int[] gardenNoAdj(int N, int[][] paths) {
        Graph(N);

        for (int i = 0; i < paths.length; i++) {
            adj[paths[i][0]].add(paths[i][1]);
            adj[paths[i][1]].add(paths[i][0]);
        }

        int result[]=new int[V];
        boolean available[]=new boolean[V];

        Arrays.fill(result,-1);
        Arrays.fill(available,true);

        for (int v = 1; v <= V; v++) {

            Iterator<Integer> itr=adj[v].listIterator();
            while (itr.hasNext()){
                int u=itr.next()-1;
                if(result[u] != -1)
                    available[result[u]-1]=false;
            }
            int cr;
            for (cr=0;cr<V;cr++)
                if(available[cr])
                    break;

            result[v-1]=cr+1;
            Arrays.fill(available,true);
        }

        return result;
    }
}
