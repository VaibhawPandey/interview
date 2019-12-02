package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;

import java.util.*;

public class VivekAndFriends {

    static int V;
    static LinkedList<Integer> adj[];
    static int ans=Integer.MAX_VALUE;

    static void Graph(int v){
        V=v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt(),e=scanner.nextInt();

        Graph(v);
        for (int i = 0; i < e; i++) {
            int src=scanner.nextInt()-1,dest=scanner.nextInt()-1;
            adj[src].add(dest);
        }

        for (int i = 0; i < V; i++) {
            BFS(i);
        }

        System.out.println(ans);

    }

    private static void BFS(int src) {

        int count=0;
        boolean visited[]=new boolean[V];
        Arrays.fill(visited,false);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){

            int queue_element=queue.poll();
            visited[queue_element] = true;
            count++;

            Iterator<Integer> itr=adj[queue_element].listIterator();
            while (itr.hasNext()){
                int next=itr.next();
                if(!visited[next])
                    queue.add(next);
            }

        }

        ans = Math.min(ans,count);
    }
}
