package com.MyCode.Graph.BFSANDDFS.Medium;

import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.Iterator;

public class CountPossiblePaths {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        boolean visited[]=new boolean[4];
        countPaths(s,d,visited,g);
        System.out.println(path);
    }

    static int path=0;
    private static void countPaths(int s, int d,boolean visited[],Graph graph) {

        visited[s] = true;

        if(s == d)
            path++;
        else {

            Iterator<Integer> itr = graph.adj[s].listIterator();
            while (itr.hasNext()) {
                int u = itr.next();
                if (!visited[u])
                    countPaths(u, d, visited, graph);
            }
        }

        visited[s]=false;
    }
}
