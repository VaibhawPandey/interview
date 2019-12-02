package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class CheckCyclicDirectedGraph {

    private static int V;
    private static LinkedList<Integer> adj[];

    static void Graph(int v){
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();

    }

    public static void main(String[] args) {

        CheckCyclicDirectedGraph checkCyclicDirectedGraph=new CheckCyclicDirectedGraph();
        checkCyclicDirectedGraph.Graph(4);
        checkCyclicDirectedGraph.addEdge(0, 1);
        checkCyclicDirectedGraph.addEdge(0, 2);
        checkCyclicDirectedGraph.addEdge(1, 2);
        checkCyclicDirectedGraph.addEdge(2, 0);
        checkCyclicDirectedGraph.addEdge(2, 3);
        checkCyclicDirectedGraph.addEdge(3, 3);

        if(isCyclic())
            System.out.println("Graph is cyclic");
        else
            System.out.println("Graph is not cyclic");

    }

    public static boolean isCyclic() {

        boolean visited[]=new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(isCyclicUtil(i,visited,recStack))
                return true;
        }
        return false;
    }

    private static boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {

        if(recStack[v])
            return true;

        if(visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        Iterator<Integer> itrList=adj[v].listIterator();
        while (itrList.hasNext()){
            if(isCyclicUtil(itrList.next(),visited,recStack))
                return true;
        }

        recStack[v] = false;

        return false;
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }
}
