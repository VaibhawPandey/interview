package com.Techgig.SamsungContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EarthQuakeInAfricaTemp {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt(),e=scanner.nextInt(),r=scanner.nextInt();

        List<Integer> floodEffectedNode =new ArrayList<>();
        for (int i = 0; i < r; i++)
            floodEffectedNode.add(scanner.nextInt());

        int graph[][]=new int[v+1][v+1];
        for (int i = 0; i <= v; i++)
        Arrays.fill(graph[i],Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            int tempU=scanner.nextInt();
            int tempV=scanner.nextInt();
            int w=scanner.nextInt();
            graph[tempU][tempV] = w;
            graph[tempV][tempU] = w;
        }

        int dist[][]=new int[v+1][v+1];

        for (int i = 1; i <=v; i++)
            for (int j = 1; j <=v; j++)
                dist[i][j] = graph[i][j];

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <=v; i++) {
                for (int j = 1; j <= v; j++) {
                   if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                       if(dist[i][k]+dist[k][j] < dist[i][j])
                           dist[i][j] = dist[i][k]+dist[k][j];
                   }
                }
            }
        }

        for (int i = 1; i <=v; i++) {
            for (int j = 1; j <= v; j++) {
                if(dist[i][j] == Integer.MAX_VALUE)
                    System.out.print(-1 +" ");
                else
                    System.out.print(dist[i][j] +" ");
            }
            System.out.println();
        }

        List<Integer> nFloodEffectedNode=new ArrayList<>();
        for (int i = 1; i <=v; i++)
            if(!floodEffectedNode.contains(i))
                nFloodEffectedNode.add(i);

        int min_Value = Integer.MAX_VALUE;
        int lastNode=-1,minSrcNode=-1;
        for (int i = 0; i < nFloodEffectedNode.size(); i++) {
            int srcNode=nFloodEffectedNode.get(i);
            int size=floodEffectedNode.size();
            //int tempMinValue=Integer.MAX_VALUE;
            for (int j = 0; j < floodEffectedNode.size(); j++) {
                int value = 0;
                int p=srcNode,q=-1;
                for (int k = 0; k < floodEffectedNode.size(); k++) {
                    q = floodEffectedNode.get((j+k)%size);
                    value += dist[p][q];
                    p=q;
                }

                if(min_Value>value){
                    min_Value=value;
                    lastNode=q;
                    minSrcNode=srcNode;
                }else if(min_Value == value){
                    if(dist[q][srcNode] < dist[lastNode][minSrcNode]){
                        lastNode=q;
                        minSrcNode = srcNode;
                    }
                }


            }
        }

        System.out.println(lastNode +"--" +minSrcNode);
        min_Value += dist[lastNode][minSrcNode];

        System.out.println(min_Value);

    }


}
