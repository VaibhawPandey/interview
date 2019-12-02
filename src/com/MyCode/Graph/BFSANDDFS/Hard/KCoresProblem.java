package com.MyCode.Graph.BFSANDDFS.Hard;

import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.Arrays;
import java.util.Iterator;

public class KCoresProblem {

    static boolean visited[];
    static int vertexDegreeCount[];
    public static void main(String[] args) {

        int k=3;
        Graph graph= new Graph(9);
        graph.bidirectionalAddEdge(0, 1);
        graph.bidirectionalAddEdge(0, 2);
        graph.bidirectionalAddEdge(1, 2);
        graph.bidirectionalAddEdge(1, 5);
        graph.bidirectionalAddEdge(2, 3);
        graph.bidirectionalAddEdge(2, 4);
        graph.bidirectionalAddEdge(2, 5);
        graph.bidirectionalAddEdge(2, 6);
        graph.bidirectionalAddEdge(3, 4);
        graph.bidirectionalAddEdge(3, 6);
        graph.bidirectionalAddEdge(3, 7);
        graph.bidirectionalAddEdge(4, 6);
        graph.bidirectionalAddEdge(4, 7);
        graph.bidirectionalAddEdge(5, 6);
        graph.bidirectionalAddEdge(5, 8);
        graph.bidirectionalAddEdge(6, 7);
        graph.bidirectionalAddEdge(6, 8);

        KCores(k,graph);
    }

    private static void KCores(int k, Graph graph) {

        visited=new boolean[graph.V];
        Arrays.fill(visited,false);
        vertexDegreeCount= new int[graph.V];

        int startIndex=0,minDeg=Integer.MAX_VALUE;
        for (int i = 0; i < graph.V; i++) {

            vertexDegreeCount[i] = graph.adj[i].size();
            if(vertexDegreeCount[i]<minDeg){
                minDeg = vertexDegreeCount[i];
                startIndex=i;
            }
        }

        DFSUtil(startIndex,graph,k);

        for (int v = 0; v < graph.V; v++) {
            if(!visited[v])
                DFSUtil(v,graph,k);
        }

        for (int v = 0; v < graph.V; v++) {
            if(vertexDegreeCount[v] >= k){
                System.out.print("[" +v +"]");

                Iterator<Integer> itr=graph.adj[v].listIterator();
                while (itr.hasNext()){
                    int r=itr.next();

                    if(vertexDegreeCount[r] >= k)
                        System.out.print("-->" +r);
                }
                System.out.println();
            }
        }


    }

    private static boolean DFSUtil(int startIndex, Graph graph,int k) {

          visited[startIndex] = true;
          Iterator<Integer> itr = graph.adj[startIndex].listIterator();

          while (itr.hasNext()){
              int v= itr.next();

              if(vertexDegreeCount[v]<k)
                  vertexDegreeCount[startIndex]--;

              if(!visited[v])
                  if(DFSUtil(v,graph,k))
                      vertexDegreeCount[v]--;
          }

          return (vertexDegreeCount[startIndex]<k);
    }
}
