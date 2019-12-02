package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstraAlgo {

    static String output[];
    static int V;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t= scanner.nextInt();

        output=new String[t];
        for (int i = 0; i < t; i++) {

            output[i] ="";
            int v=scanner.nextInt(),e=scanner.nextInt();
            V=v;
            int graph[][] = new int[v][v];

            for (int j = 0; j < e; j++) {
                int x=scanner.nextInt()-1,y=scanner.nextInt()-1;
                int w=scanner.nextInt();
                graph[x][y]=w;
                graph[y][x]=w;
            }

            int s=scanner.nextInt();

            shortestPath(graph,s-1,i);
        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);


    }

    private static void shortestPath(int[][] graph,int s,int loopCount) {

        boolean dspSet[]=new boolean[V];
        int distance[]=new int[V];

        Arrays.fill(dspSet,false);
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[s]=0;

        for (int count = 0; count < V-1; count++) {

            int u=min_Position(distance,dspSet);
            dspSet[u] = true;

            for (int v = 0; v < V; v++) {

                if(graph[u][v] != 0 && dspSet[v] == false && distance[u] != Integer.MAX_VALUE
                        && (distance[u] + graph[u][v]) < distance[v])
                    distance[v] = distance[u] +graph[u][v];
            }

        }

        for (int i = 0; i < V; i++)
            if (i != s) {
                distance[i] = distance[i] == Integer.MAX_VALUE ? -1 : distance[i];
                output[loopCount] += distance[i] + " ";
            }


    }

    private static int min_Position(int[] distance, boolean dspSet[]) {

        int min_position=-1,min_value=Integer.MAX_VALUE;

        for (int v = 0; v < V; v++) {

            if(dspSet[v] == false && distance[v]<min_value){
                min_position=v;
                min_value=distance[v];
            }
        }

        return min_position;
    }

}
