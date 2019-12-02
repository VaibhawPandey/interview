package com.MyCode.Graph.ShortestPath;

public class Graph {

     public int V,E;
     public Edge edge[];

    public Graph(int v,int e){
        this.V=v;
        this.E = e;
        this.edge = new Edge[this.E];
        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    public class Edge{
        public int src,dest,weight;
    }

}


