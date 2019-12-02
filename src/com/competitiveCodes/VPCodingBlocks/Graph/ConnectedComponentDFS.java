package com.competitiveCodes.VPCodingBlocks.Graph;

import java.util.LinkedList;

public class ConnectedComponentDFS {

    static int v;
    static LinkedList<Integer> adjLinkedArray[];

    void Graph(int V){
        this.v = V;
        adjLinkedArray = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adjLinkedArray[i] = new LinkedList<>();
    }

    //Undirected Graph
    void addEdge(int src,int dest){
        // Direct Map
        adjLinkedArray[src].add(dest);
        // Reverse Map
        adjLinkedArray[dest].add(src);
    }






    public static void main(String[] args) {

        ConnectedComponentDFS connectedComponentDFS=new ConnectedComponentDFS();
        connectedComponentDFS.Graph(5);

        connectedComponentDFS.addEdge(1, 0);
        connectedComponentDFS.addEdge(2, 3);
        connectedComponentDFS.addEdge(3, 4);

        connectedComponentDFS.setConnectedComponent(0);

    }

    public void setConnectedComponent(int s) {

        boolean visited[]=new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!visited[i])
                DFSUtil(i,visited);
        }


    }

    private void DFSUtil(int i, boolean[] visited) {

        visited[i] = true;

        System.out.print(i +" ");

        for (int x:adjLinkedArray[i]){
            if(!visited[x]) {
                DFSUtil(x, visited);
                System.out.println();
            }
        }

    }
}
