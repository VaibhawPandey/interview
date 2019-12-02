package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSForShortestPath {

    int v;
    LinkedList<Integer> adj[];

    void Graph(int V){
        this.v=V;

        adj=new LinkedList[V];

        for (int i = 0; i < v; i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v,int w){
        adj[v].add(w);
    }

    void BFSForShortestPath(int s){

        int src=s;

        int visited[]=new int[v];

        for (int i = 0; i < v; i++)
            visited[i] = Integer.MAX_VALUE;

        LinkedList<Integer> queue=new LinkedList<>();

        visited[s]=1;
        queue.add(s);

        while (queue.size() != 0){
            s=queue.poll();
            Iterator<Integer> itr=adj[s].listIterator();
            while (itr.hasNext()){
                int i=itr.next();
                if(visited[i] == Integer.MAX_VALUE){
                    visited[i] = 1 + visited[s];
                    queue.add(i);
                }
            }
        }

        for (int i = 0; i < v; i++)
            System.out.println("Distance from " +src +" to " +i +" is " +visited[i]);

    }



    public static void main(String[] args) {
        BFSForShortestPath bfsForShortestPath=new BFSForShortestPath();
        bfsForShortestPath.Graph(4);
        bfsForShortestPath.addEdge(0,1);
        bfsForShortestPath.addEdge(0,2);
        bfsForShortestPath.addEdge(1,2);
        bfsForShortestPath.addEdge(2,0);
        bfsForShortestPath.addEdge(2,3);
        bfsForShortestPath.addEdge(3,3);
        bfsForShortestPath.BFSForShortestPath(0);
    }
}
