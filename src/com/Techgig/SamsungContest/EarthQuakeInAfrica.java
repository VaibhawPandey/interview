package com.Techgig.SamsungContest;



import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.*;

public class EarthQuakeInAfrica {

    static int V;
    static List<Integer> nodestoCoverList=new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt(),ntoCover=scanner.nextInt();

        for (int i = 0; i < ntoCover; i++) 
            nodestoCoverList.add(scanner.nextInt()-1);

        V=n;
        
        int graph[][]=new int[n][n];

        for (int i = 0; i < m; i++) {
            int x=scanner.nextInt() - 1;
            int y=scanner.nextInt() - 1;
            graph[x][y] = scanner.nextInt();
            graph[y][x] = graph[x][y];
        }

        int min_Value=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(!nodestoCoverList.contains(i)){
                System.out.println("Value:-" +i);
                int temp_min=dijskstra(graph,i);
                min_Value = Math.min(min_Value,temp_min);
            }
        }

        System.out.println(min_Value*2);
        
    }

    static boolean visited[];
    static int min_Cost=0;

    private static int dijskstra(int[][] graph, int src) {

        Graph graph1=new Graph(graph.length);
        boolean dstSet[]=new boolean[V];
        int dist[]=new int[V];
        Arrays.fill(dstSet,false);
        Arrays.fill(dist,Integer.MAX_VALUE);


        dist[src] = 0;
        for (int i = 0; i < V; i++) {
            if(!nodestoCoverList.contains(i) && i!= src)
                dstSet[i] = true;
        }
        //dstSet[src] = true;

        for (int count = 0; count < V-1; count++) {

            int u=min_Cost_Node(dist,dstSet);

            if(u == -1)
                continue;
            dstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if(dstSet[v]==false && graph[u][v] != 0 && dist[u]!= Integer.MAX_VALUE && graph[u][v] + dist[u]<dist[v]) {
                    System.out.println(u +"--" +v);
                    graph1.bidirectionalAddEdge(u,v);
                    dist[v] = graph[u][v] + dist[u];
                }
            }
        }


        visited = new boolean[graph.length];
        Arrays.fill(visited,false);
        min_Cost=0;
        for (Integer node:nodestoCoverList) {
              int r=-1;
             if(!visited[node]) {
                min_Cost= dfsUtil(src,graph1,nodestoCoverList,src,dist);
               /* if(k!=src)
                    min_Cost += dist[k]*2;*/
                visited[src] = false;
             }
        }

        System.out.println();

        return min_Cost;
    }

    private static int dfsUtil(int src, Graph graph1, List<Integer> nodestoCoverList, int mainSrc, int[] dist) {
        int r=src;
        Iterator<Integer> itr=graph1.adj[r].listIterator();

        if(!itr.hasNext() && r != mainSrc)
            min_Cost += dist[r]*2;

        while (itr.hasNext()){
            int v=itr.next();
            if(nodestoCoverList.contains(v) && !visited[v]) {
                visited[v] = true;
                min_Cost += dfsUtil(v, graph1,nodestoCoverList,mainSrc, dist);
            }
        }

        return min_Cost;
    }

    private static int min_Cost_Node(int[] dist, boolean[] dstSet) {

        int min_value=Integer.MAX_VALUE,min_position=-1;

        for (int v = 0; v < V; v++) {
            if(dstSet[v] == false && dist[v]<min_value){
                min_value=dist[v];
                min_position=v;
            }
        }
        
        return min_position;
    }
}

