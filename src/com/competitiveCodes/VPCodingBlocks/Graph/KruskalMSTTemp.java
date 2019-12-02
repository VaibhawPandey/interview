package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

public class KruskalMSTTemp {

    class Edge implements Comparable<Edge>{
        int src,dest,weight;


        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight-compareEdge.weight;
        }
    }

    int V,E;
    Edge edge[];

    void Graph(int v,int e){
        this.V=v;
        this.E = e;

        edge = new Edge[E];
        for (int i = 0; i < E; i++)
            edge[i]= new Edge();
    }

    class subset{
        int parent,rank;
    }


    private void krushkalAlgo(KruskalMSTTemp kruskalMSTTemp) {

        Edge result[]=new Edge[V];

        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsetList[]=new subset[V];

        int i=0,e=0;

        for (int j = 0; j < V; j++) {
            subsetList[j] = new subset();
            subsetList[j].parent = j;
            subsetList[j].rank = 0;
        }

        while (e < V-1){

            Edge next_Edge = edge[i++];
            int x=find(subsetList,next_Edge.src);
            int y= find(subsetList,next_Edge.dest);

            if(x!=y){
                result[e++] = next_Edge;
                Union(subsetList,x,y);
            }

        }

        for (int j = 0; j < result.length-1; j++)
            System.out.println(result[j].src +"--" +result[j].dest +"--" +result[j].weight);


    }

    private void Union(subset[] subsetList, int x, int y) {

        int xSrc = find(subsetList,x);
        int yDest = find(subsetList,y);

        if(subsetList[xSrc].rank > subsetList[yDest].rank)
            subsetList[yDest].parent = xSrc;
        else if(subsetList[xSrc].rank < subsetList[yDest].rank)
            subsetList[xSrc].parent = yDest;
        else {
            subsetList[yDest].parent = xSrc;
            subsetList[xSrc].rank++;
        }
    }

    private int find(subset[] subsetList, int src) {

        if(subsetList[src].parent != src)
            return find(subsetList,subsetList[src].parent);

        return subsetList[src].parent;
    }


    public static void main(String[] args) {
        int V=4,E=5;

        KruskalMSTTemp kruskalMSTTemp=new KruskalMSTTemp();
        kruskalMSTTemp.Graph(V,E);

        // add edge 0-3
        kruskalMSTTemp.edge[0].src = 0;
        kruskalMSTTemp.edge[0].dest = 1;
        kruskalMSTTemp.edge[0].weight = 10;

        // add edge 0-2
        kruskalMSTTemp.edge[1].src = 0;
        kruskalMSTTemp.edge[1].dest = 2;
        kruskalMSTTemp.edge[1].weight = 6;

        // add edge 0-3
        kruskalMSTTemp.edge[2].src = 0;
        kruskalMSTTemp.edge[2].dest = 3;
        kruskalMSTTemp.edge[2].weight = 5;

        // add edge 1-3
        kruskalMSTTemp.edge[3].src = 1;
        kruskalMSTTemp.edge[3].dest = 3;
        kruskalMSTTemp.edge[3].weight = 15;

        // add edge 2-3
        kruskalMSTTemp.edge[4].src = 2;
        kruskalMSTTemp.edge[4].dest = 3;
        kruskalMSTTemp.edge[4].weight = 4;

        kruskalMSTTemp.krushkalAlgo(kruskalMSTTemp);
    }



}
