package com.practice;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class KruskalAlgo {

    static int V,E;
    static Edge edges[];

    static class Edge implements Comparable<Edge>
    {
        int  src,dest,weight;


        @Override
        public int compareTo(Edge comparedEdge) {
            return this.weight - comparedEdge.weight;
        }
    }

    static class Subset{
        int parent,rank;
    }

    static void Graph(int v,int e){
        V=v;
        E=e;
        edges = new Edge[E];

        //Collections.sort();

        for (int i = 0; i < E; i++)
            edges[i] = new Edge();
    }

    private void krushkalMST() {

        Edge result[]=new Edge[V-1];
        //Arrays.fill(result,-1);


        Arrays.sort(edges);

        Subset subset[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        int e= 0,i=0;

        while (e < V-1){

            Edge next_Edge = edges[i++];
            int xSrc = find(subset,next_Edge.src);
            int yDest = find(subset,next_Edge.dest);

            if(xSrc != yDest){
                result[e++] = next_Edge;
                UnionSubset(subset,xSrc,yDest);
            }
        }

        for (int j = 0; j < result.length; j++)
            System.out.println(result[j].src +"--" +result[j].dest +"=" +result[j].weight);
    }

    private void UnionSubset(Subset[] subset, int xSrc, int yDest) {

        int x=find(subset,xSrc),y=find(subset,yDest);

        if(subset[x].rank>subset[y].rank)
            subset[y].rank = x;
        else if(subset[x].rank<subset[y].rank)
            subset[x].rank = y;
        else {
            subset[x].parent = y;
            subset[y].rank++;
        }
    }

    private int find(Subset[] subset, int i) {

        if(subset[i].parent != i)
            return find(subset,subset[i].parent);

        return subset[i].parent;
    }

    public static void main(String[] args) {

        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        KruskalAlgo kruskalAlgo=new KruskalAlgo();
        kruskalAlgo.Graph(V,E);

        // add edge 0-1
        kruskalAlgo.edges[0].src = 0;
        kruskalAlgo.edges[0].dest = 1;
        kruskalAlgo.edges[0].weight = 10;

        // add edge 0-2
        kruskalAlgo.edges[1].src = 0;
        kruskalAlgo.edges[1].dest = 2;
        kruskalAlgo.edges[1].weight = 6;

        // add edge 0-3
        kruskalAlgo.edges[2].src = 0;
        kruskalAlgo.edges[2].dest = 3;
        kruskalAlgo.edges[2].weight = 5;

        // add edge 1-3
        kruskalAlgo.edges[3].src = 1;
        kruskalAlgo.edges[3].dest = 3;
        kruskalAlgo.edges[3].weight = 15;

        // add edge 2-3
        kruskalAlgo.edges[4].src = 2;
        kruskalAlgo.edges[4].dest = 3;
        kruskalAlgo.edges[4].weight = 4;

        kruskalAlgo.krushkalMST();
    }
}
