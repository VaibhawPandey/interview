package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.*;

public class TopologicalSortDFS {

    int v;
    LinkedList<Integer> adj[];
    boolean visited[];

    TopologicalSortDFS(int V){

        this.v=V;
        adj=new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    private void addEdge(int v, int w) {
       adj[v].add(w);
    }

    private void topologicalSort() {

        Stack stack=new Stack();
        visited=new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;

        for (int i = 0; i < v; i++) {
            if(!visited[i])
            topologicalSortUtil(i,stack);
        }

        while (!stack.empty())
            System.out.print(stack.pop() +" ");



    }

    private void topologicalSortUtil(int v, Stack stack) {

        visited[v] = true;


        int i;
        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){
            i=itr.next();
            if(!visited[i])
                topologicalSortUtil(i,stack);
        }

        stack.push(v);
    }

    public static void main(String[] args) {

        TopologicalSortDFS topologicalSortDFS = new TopologicalSortDFS(6);
        topologicalSortDFS.addEdge(5, 2);
        topologicalSortDFS.addEdge(5, 0);
        topologicalSortDFS.addEdge(4, 0);
        topologicalSortDFS.addEdge(4, 1);
        topologicalSortDFS.addEdge(2, 3);
        topologicalSortDFS.addEdge(3, 1);

        topologicalSortDFS.topologicalSort();
    }




}
