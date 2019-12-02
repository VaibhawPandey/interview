package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortBFS {

    int v;
    LinkedList<Integer> adj[];

    TopologicalSortBFS(int V){
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

        LinkedList<Integer> queue=new LinkedList<>();
        Integer indegree[]=new Integer[v];

        for (int i = 0; i < v; i++) {
            Iterator<Integer> itr = adj[i].listIterator();
            while (itr.hasNext())
                indegree[itr.next()]++;
        }

        for (int i = 0; i < v; i++)
            if (indegree[i] == 0)
                queue.add(i);

        if(queue.size()==0)
            queue.add(0);

        for (int i = 0; i < v; i++){
            while (!queue.isEmpty()){

                int s=queue.poll();
                Iterator<Integer> itr = adj[s].listIterator();

                while (itr.hasNext()){
                   int r=itr.next();
                   indegree[r]--;
                   if(indegree[r] == 0)
                       queue.add(r);
                }

            }
        }

        for (int i = 0; i < queue.size(); i++)
            System.out.print(queue.get(i) +" ");


    }

    public static void main(String[] args) {

        TopologicalSortBFS topologicalSortBFS = new TopologicalSortBFS(6);
        topologicalSortBFS.addEdge(5, 2);
        topologicalSortBFS.addEdge(5, 0);
        topologicalSortBFS.addEdge(4, 0);
        topologicalSortBFS.addEdge(4, 1);
        topologicalSortBFS.addEdge(2, 3);
        topologicalSortBFS.addEdge(3, 1);

        topologicalSortBFS.topologicalSort();


    }




}
