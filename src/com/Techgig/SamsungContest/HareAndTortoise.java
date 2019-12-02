package com.Techgig.SamsungContest;

import java.util.Arrays;
import java.util.Scanner;

public class HareAndTortoise {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        int graph[][]=new int[n+1][n+1];
        int u,v,diff;

        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            diff = -scanner.nextInt() + scanner.nextInt();
            graph[u][v] = diff;
        }

        int min_Value=Integer.MAX_VALUE,min_path=-1;
        for (int i = 1; i <= n; i++) {
            OutputValue outputValue = getMinPath(i,graph);
            if(outputValue.min_Value<min_Value){
                min_Value=outputValue.min_Value;
                min_path=outputValue.min_path;
            }
        }

        System.out.println(min_path +"\t" +min_Value);


    }


    private static OutputValue getMinPath(int src, int[][] graph) {

        int min_cost_position = src,last_min_position=-1,value=0,path=0;
        OutputValue outputValue=new OutputValue();
        boolean visited[]=new boolean[graph.length];
        Arrays.fill(visited,false);

        while (true){
            last_min_position = min_cost_position;
            min_cost_position = getMinCostPosition(min_cost_position,graph,visited);

            if(min_cost_position == -1){
                value=Integer.MAX_VALUE;
                break;
            }

            value += graph[last_min_position][min_cost_position];
            path++;

            if(min_cost_position == src)
                break;
            else
                visited[min_cost_position] = true;
        }

        outputValue.min_Value=value;
        outputValue.min_path=path;

        return outputValue;
    }

    private static int getMinCostPosition(int src, int[][] graph, boolean[] visited) {

        int min_position = -1,min_Value=Integer.MAX_VALUE;

        for (int i = 1; i < graph.length; i++) {
            if(graph[src][i]<min_Value && graph[src][i] != 0 && visited[i] == false){
                min_Value=graph[src][i];
                min_position=i;
            }
        }

        return min_position;
    }

     static class OutputValue{
        static int min_Value;
        static int min_path;
    }
}
