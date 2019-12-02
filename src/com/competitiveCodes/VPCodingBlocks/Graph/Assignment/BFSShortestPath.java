package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;




import java.util.*;

public class BFSShortestPath {

    static int V;
    static LinkedList<Integer> adj[];
    static int weight;
    static int ans[];
    static String output[];

    static void Graph(int v){
       V = v;
       adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        output=new String[t];

        for (int i = 0; i < t; i++) {

            output[i] = new String();
            int v=scanner.nextInt();
            int e=scanner.nextInt();

            Graph(v);

            for (int j = 0; j < e; j++) {
                int src=scanner.nextInt()-1,dest=scanner.nextInt()-1;
                adj[src].add(dest);
                adj[dest].add(src);
            }

            int s = scanner.nextInt()-1;

            BFS(s,i);

        }

        for (int i = 0; i < t; i++)
            System.out.println(output[i]);


    }

    private static void BFS(int s,int count) {

        boolean visited[]=new boolean[V];
        ans=new int[V];
        Arrays.fill(visited,false);
        Arrays.fill(ans,-1);

        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        weight = 6;

        BFSUtil(visited,ans,queue);

        for (int i = 0; i < ans.length; i++)
            if(i != s)
                output[count] +=ans[i] + " ";


    }

    private static void BFSUtil(boolean[] visited, int[] ans, Queue<Integer> queue) {

        while (!queue.isEmpty()) {

            int v = queue.poll();

            Iterator<Integer> itr = adj[v].listIterator();
            while (itr.hasNext()) {
                int u = itr.next();
                if (!visited[u]) {
                    visited[u] = true;
                    ans[u] = weight;
                    queue.add(u);
                }
            }
            weight += 6;

        }

    }


}
