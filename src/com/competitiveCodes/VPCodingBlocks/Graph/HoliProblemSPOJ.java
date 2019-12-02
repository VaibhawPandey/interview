package com.competitiveCodes.VPCodingBlocks.Graph;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.LinkedList;

public class HoliProblemSPOJ {

     static int v;
     static LinkedList<Pair<Integer,Integer>> adj[];
     static int count[];

     HoliProblemSPOJ(int V){
         this.v=V;
         adj = new LinkedList[V+1];

         for (int i = 1; i <= V; i++)
             adj[i] = new LinkedList<>();
     }

     void addEdge(int u,int v,int w){
         adj[u].add(new Pair<>(v,w));
         adj[v].add(new Pair<>(u,w));
     }

    private void dfs() {

         boolean visited[]=new boolean[v+1];
         count=new int[v+1];

         dfsHelper(1,visited);
/*
        for (int i = 1; i <= v; i++)
            System.out.println(count[i]);*/

    }

    private int dfsHelper(int v, boolean[] visited) {

         visited[v]=true;
         count[v] = 1;

        Iterator<Pair<Integer,Integer>> itr=adj[v].listIterator();

        while (itr.hasNext()){
            int i=itr.next().getKey();
            if(!visited[i])
                count[v] += dfsHelper(i,visited);
        }

        return count[v];
    }


    public static void main(String[] args) {

         HoliProblemSPOJ holiProblemSPOJ=new HoliProblemSPOJ(4);
         holiProblemSPOJ.addEdge(1,2,3);
         holiProblemSPOJ.addEdge(2,3,2);
         holiProblemSPOJ.addEdge(4,3,2);
         holiProblemSPOJ.dfs();
         int ans=0;

        // Acc to Pigeonhole prin min(N,N-X) is considered . Node value is multipled because all the nodes have to go through  
        for (int i = 1; i <= v; i++)
            //System.out.println(i +"--" +count[i] +"--" +count[i] +"--" +Math.min(count[i],4-count[i]));
            ans += Math.min(count[i], 4 - count[i]) * 2 * adj[i].getFirst().getValue();


        System.out.println(ans);

    }


}
