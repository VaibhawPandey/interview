package com.practice;

import com.MyCode.Graph.ShortestPath.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class UnionFindAlgo {

    public static void main(String[] args) {
        int V = 3, E = 3;
        Graph graph=new Graph(V,E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if(isCycle(graph))
            System.out.println("Cycle exists");
        else
            System.out.println("Cycle does not exists");
    }

    private static boolean isCycle(Graph graph) {

        int parent[]=new int[graph.V];
        Arrays.fill(parent,-1);

        for (int i=0;i<graph.E;i++){
            int xSrc = find(parent,graph.edge[i].src);
            int yDest = find(parent,graph.edge[i].dest);

            if(xSrc == yDest)
                return true;

            parent = unionAlgo(parent,xSrc,yDest);
        }

        return false;
    }

    private static int[] unionAlgo(int[] parent, int xSrc, int yDest) {

        int x=find(parent,xSrc);
        int y=find(parent,yDest);

        parent[x] = y;
        return parent;
    }

    private static int find(int[] parent, int src) {

        if(parent[src] == -1)
            return src;

        return find(parent,parent[src]);
    }
}
