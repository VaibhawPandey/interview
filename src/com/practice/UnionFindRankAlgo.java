package com.practice;

import com.MyCode.Graph.ShortestPath.Graph;

public class UnionFindRankAlgo {

    public static void main(String[] args) {
        int V = 3, E = 3;
        Graph graph=new Graph(V,E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if(unionFindAlgo(graph))
            System.out.println("Cycle exists");
        else
            System.out.println("Cycle does not exists");
    }

    private static boolean unionFindAlgo(Graph graph) {

        Subset subset[]=new Subset[graph.V];
        for (int i = 0; i < graph.V; i++)
            subset[i] = new Subset();

        for (int i = 0; i < graph.E; i++) {

            int xSrc=find(subset,graph.edge[i].src);
            int yDest = find(subset,graph.edge[i].dest);

            if(xSrc == yDest)
                return true;

            subset = union(subset,xSrc,yDest);
        }

        return false;
    }

    private static Subset[] union(Subset[] subset, int xSrc, int yDest) {

        int x=find(subset,xSrc);
        int y=find(subset,yDest);

        if(subset[x].rank>subset[y].rank)
            subset[y].parent = x;
        else if(subset[x].rank<subset[y].rank)
            subset[x].parent = y;
        else {
            subset[x].parent = y;
            subset[y].rank++;
        }

        return subset;
    }

    private static int find(Subset[] subset, int src) {

         if(subset[src].parent == -1)
             return src;

         return find(subset,subset[src].parent);
    }

    static class Subset{
        int parent;
        int rank;

        Subset(){
            parent=-1;
            rank = 0;
        }
    }
}
