package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*
  * KosaRaju's Algo
  * https://www.geeksforgeeks.org/strongly-connected-components/
 */
public class StronglyConnectedComponent {

    private int v;
    private LinkedList<Integer> adj[];
    Stack stack=new Stack();

    StronglyConnectedComponent(int V){
        this.v=V;
        adj = new LinkedList[V];

        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u,int v) {
        adj[u].add(v);
    }

    private void findSCC() {

        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);



        for (int i = 0; i < v; i++)
            if(!visited[i])
                fillStack(i,visited);

        /*while (!stack.empty())
            System.out.println("D:-" +stack.pop());*/



        StronglyConnectedComponent sCC=getReverseTopology();

        Arrays.fill(visited,false);

        while (!stack.empty()){
            int v= (int) stack.pop();

            if(!visited[v]){
                sCC.dFSUtil(v,visited);
                System.out.println();
            }


        }


    }

    private void dFSUtil(int v, boolean[] visited) {

        visited[v] = true;
        System.out.print(v +" ");

        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){
            int k=itr.next();
            if(!visited[k])
                dFSUtil(k,visited);
        }
    }

    public StronglyConnectedComponent getReverseTopology() {
        StronglyConnectedComponent stronglyConnectedComponent=new StronglyConnectedComponent(v);

        for (int i = 0; i < v; i++) {
            Iterator<Integer> iterator=adj[i].listIterator();

            while (iterator.hasNext()){
                int j=iterator.next();
                stronglyConnectedComponent.adj[j].add(i);
            }
        }

        return stronglyConnectedComponent;
    }

    private void fillStack(int v, boolean[] visited) {

        visited[v]=true;

        Iterator<Integer> itr=adj[v].listIterator();

        while (itr.hasNext()){

            int k=itr.next();

            if(!visited[k])
                fillStack(k,visited);

        }

        stack.push(v);
    }


    public static void main(String[] args) {

        StronglyConnectedComponent stronglyConnectedComponent=new StronglyConnectedComponent(5);
        stronglyConnectedComponent.addEdge(1, 0);
        stronglyConnectedComponent.addEdge(0, 2);
        stronglyConnectedComponent.addEdge(2, 1);
        stronglyConnectedComponent.addEdge(0, 3);
        stronglyConnectedComponent.addEdge(3, 4);

        stronglyConnectedComponent.findSCC();
    }


}
