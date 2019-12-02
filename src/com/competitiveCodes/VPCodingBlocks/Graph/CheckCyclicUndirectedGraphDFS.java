package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;



public class CheckCyclicUndirectedGraphDFS {

    static int v;
    static LinkedList<Integer> adj[];

    CheckCyclicUndirectedGraphDFS(int V){
        v=V;
        adj=new LinkedList[v];

        for (int i = 0; i < v; i++)
            adj[i]=new LinkedList<>();
    }

    public static void main(String[] args) {

       CheckCyclicUndirectedGraphDFS checkCyclicUndirectedGraphDFS=new CheckCyclicUndirectedGraphDFS(5);

        checkCyclicUndirectedGraphDFS.addEdge(1, 0);
        checkCyclicUndirectedGraphDFS.addEdge(0, 2);
        checkCyclicUndirectedGraphDFS.addEdge(2, 0);
        checkCyclicUndirectedGraphDFS.addEdge(0, 3);
        checkCyclicUndirectedGraphDFS.addEdge(3, 4);

        if(checkCyclicUndirectedGraphDFS.isCyclic())
            System.out.println("Graph contain cycle");
        else
            System.out.println("Graph does not contain cycle");


        checkCyclicUndirectedGraphDFS=new CheckCyclicUndirectedGraphDFS(3);

        checkCyclicUndirectedGraphDFS.addEdge(0, 1);
        checkCyclicUndirectedGraphDFS.addEdge(1, 2);

        if(checkCyclicUndirectedGraphDFS.isCyclic())
            System.out.println("Graph contain cycle");
        else
            System.out.println("Graph does not contain cycle");


    }

    public static void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public boolean isCyclic() {

        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);

        for (int i = 0; i < v; i++) {
             if(!visited[i])
                 return isCyclicUtil(i,visited,-1);
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {

        visited[v]=true;
        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){

            int k=itr.next();
            if(!visited[k]){
                if(isCyclicUtil(k,visited,v))
                    return true;
            }else
                if(parent != k)
                    return true;

        }

        return false;

    }
}
