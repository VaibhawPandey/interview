package com.competitiveCodes.VPCodingBlocks.DynamicProgramming;

import java.util.*;

public class Graph {

    static int v;
    static LinkedList<Integer> adj[];

    Graph(int V){
        v=V;
        adj=new LinkedList[V];

        for (int i = 0; i < v; i++)
            adj[i]= new LinkedList<>();
    }

    static void addEdge(int v,int w){
        adj[v].add(w);
    }

    static void BFS(int i){

        boolean visited[]=new boolean[v];
        LinkedList<Integer> queue=new LinkedList<>();

        visited[i]=true;
        queue.add(i);

        while (queue.size() != 0){
             i = queue.poll();
            System.out.print(i +" ");
            Iterator<Integer> itr=adj[i].listIterator();
            while (itr.hasNext()){
                int s=itr.next();
                if(!visited[s]){
                    visited[s]=true;
                    queue.add(s);
                }
            }
        }




    }

    public static void main(String[] args) {

        Graph graph=new Graph(4);
        //int n=scanner.nextInt();
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,2);
        addEdge(2,0);
        addEdge(2,3);
        addEdge(3,3);
        BFS(2);
    }
}
