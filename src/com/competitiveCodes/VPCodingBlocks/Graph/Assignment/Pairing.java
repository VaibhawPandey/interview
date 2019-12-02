package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Pairing {


    static int V,E;
    static LinkedList<Integer> adj[];

    static void Graph(int v){
        V = v;

        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }




    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt(),e=scanner.nextInt();

        Graph(v);
        for (int i = 0; i < e; i++) {
            int src=scanner.nextInt(),dest=scanner.nextInt();
            adj[src].add(dest);
            adj[dest].add(src);
        }

        DFS();
    }

    private static void DFS() {

        boolean visited[]=new boolean[V];
        Arrays.fill(visited,false);


        int totalPairing = (V *(V-1))/2;

        for (int v = 0; v < V; v++) {
            int country_len=0;

            if(!visited[v])
                country_len = DFSUtil(visited,country_len,v);

         totalPairing -= (country_len * (country_len-1))/2;
        }

        System.out.println(totalPairing);
    }

    private static int DFSUtil(boolean[] visited, int country_len,int position) {

        visited[position] = true;
        country_len++;

        Iterator<Integer> itr = adj[position].listIterator();

        while (itr.hasNext()){
            int u=itr.next();

            if(!visited[u])
                country_len = DFSUtil(visited,country_len,u);
        }

        return country_len;

    }
}
