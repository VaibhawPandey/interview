package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;

public class KruskalMST {

    int V,E;
    Edge edge[];

    void Graph(int v,int e){
        this.V=v;
        this.E=e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    class Edge implements Comparable<Edge>{

        int src,dest,weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset{
        int parent,rank;
    }

    private void Union(subset[] subsetList, int nextSrc, int nextDest) {

        int x=find(subsetList,nextSrc);
        int y=find(subsetList,nextDest);

        if(subsetList[x].rank > subsetList[y].rank)
            subsetList[y].parent = x;
        else if(subsetList[x].rank < subsetList[y].rank)
            subsetList[x].parent = y;
        else {
            subsetList[y].parent = x;
            subsetList[x].rank++;
        }
    }

    private void krushkalAlgo(KruskalMST kruskalMST) {

        Edge result[] = new Edge[kruskalMST.V];
        for (int i = 0; i < kruskalMST.V; i++)
            result[i] = new Edge();

        Arrays.sort(kruskalMST.edge);

        subset subsetList[]=new subset[kruskalMST.V];

        for (int i = 0; i < kruskalMST.V; i++) {
            subsetList[i]=new subset();
            subsetList[i].parent = i;
            subsetList[i].rank = 0;
        }

        int i=0,e=0;

        while (e< kruskalMST.V - 1){
            Edge next_edge=kruskalMST.edge[i++];
            int nextSrc = find(subsetList,next_edge.src);
            int nextDest = find(subsetList,next_edge.dest);
            if(nextSrc != nextDest){
                result[e++]=next_edge;
                Union(subsetList,nextSrc,nextDest);
            }
        }

        for (int j = 0; j < result.length; j++)
            System.out.println(result[j].src +"--" +result[j].dest +"--" +result[j].weight);

    }



    private int find(subset[] subsetList, int i) {

        if(subsetList[i].parent != i)
            return find(subsetList,subsetList[i].parent);

        return subsetList[i].parent;
    }

    public static void main(String[] args) {

        int V=4,E=5;
        KruskalMST kruskalMST=new KruskalMST();
        kruskalMST.Graph(V,E);

        // add edge 0-3
        kruskalMST.edge[0].src = 0;
        kruskalMST.edge[0].dest = 1;
        kruskalMST.edge[0].weight = 10;

        // add edge 0-2
        kruskalMST.edge[1].src = 0;
        kruskalMST.edge[1].dest = 2;
        kruskalMST.edge[1].weight = 6;

        // add edge 0-3
        kruskalMST.edge[2].src = 0;
        kruskalMST.edge[2].dest = 3;
        kruskalMST.edge[2].weight = 5;

        // add edge 1-3
        kruskalMST.edge[3].src = 1;
        kruskalMST.edge[3].dest = 3;
        kruskalMST.edge[3].weight = 15;

        // add edge 2-3
        kruskalMST.edge[4].src = 2;
        kruskalMST.edge[4].dest = 3;
        kruskalMST.edge[4].weight = 4;

        kruskalMST.krushkalAlgo(kruskalMST);

    }


}
