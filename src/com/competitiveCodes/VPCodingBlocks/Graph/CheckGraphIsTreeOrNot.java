package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class CheckGraphIsTreeOrNot {

    static int V,E;
    static LinkedList<Integer> adj[];
    static boolean visited[];

    static void Graph(int v){
        V=v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();

    }

    static void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    static boolean isCyclic(int v,int parent){

        visited[v] = true;
        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){
            int u=itr.next();

            if (!visited[u]){
                if(isCyclic(u,v))
                    return true;
            }else
                if(u != parent)
                    return true;
        }

        return false;
    }

    private boolean isTree() {

        visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        if(isCyclic(0,-1))
            return false;

        for (int i = 0; i < V; i++) {
            if(!visited[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        CheckGraphIsTreeOrNot checkGraphIsTreeOrNot=new CheckGraphIsTreeOrNot();
        checkGraphIsTreeOrNot.Graph(5);
        checkGraphIsTreeOrNot.addEdge(1, 0);
        checkGraphIsTreeOrNot.addEdge(0, 2);
        checkGraphIsTreeOrNot.addEdge(0, 3);
        checkGraphIsTreeOrNot.addEdge(3, 4);

        if(checkGraphIsTreeOrNot.isTree())
            System.out.println("Graph is tree");
        else
            System.out.println("Graph is not a tree");
    }


}
