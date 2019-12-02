package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class JourneyToTheMoon {

    static int v;
    static LinkedList<Integer> adj[];

    JourneyToTheMoon(int V){
        this.v=V;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    private void toMoon() {

        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);

        long totalPairing = (v*(v-1))/2;
        long sumofPairing = 0;
        for (int i = 0; i < v; i++) {
            int country_len=0;
           if(!visited[i])
               country_len = dfs(i,visited,country_len);

            //System.out.println(country_len);

           totalPairing -= (country_len * (country_len-1))/2;
        }

        System.out.println(totalPairing);
    }

    private int dfs(int i, boolean[] visited, int country_len) {

        visited[i]=true;
        country_len++;

        Iterator<Integer> itr=adj[i].listIterator();

        while (itr.hasNext()){
            int v=itr.next();
            if(!visited[v])
                country_len = dfs(v,visited,country_len);
        }

        return country_len;
    }

    public static void main(String[] args) {

        JourneyToTheMoon journeyToTheMoon=new JourneyToTheMoon(5);

        journeyToTheMoon.addEdge(0,1);
        journeyToTheMoon.addEdge(2,3);
        journeyToTheMoon.addEdge(0,4);

        journeyToTheMoon.toMoon();

    }


}
