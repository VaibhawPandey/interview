package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;


import java.util.*;

public class CyberAttack {

      static class Edge implements Comparable<Edge>{

          int src,dest,cost;

          @Override
          public int compareTo(Edge comparedEdge) {
              return this.cost - comparedEdge.cost;
          }
      }

      static int V,E;
      static LinkedList<Integer> adj[];
      static List<Edge> edges;
      static int min_Cost = 0,main_min_Cost=0;
      static int min_Value = 0,main_min_Value=0;
      static boolean end_loop=false;
      static int loop_count=0;

      static void Graph(int v){
         V = v;
         adj = new LinkedList[V];

          for (int i = 0; i < V; i++)
              adj[i] = new LinkedList<>();
      }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt(),e=scanner.nextInt(),s=scanner.nextInt();
        Graph(v);
        edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int src=scanner.nextInt()-1,dest=scanner.nextInt()-1,cost=scanner.nextInt();

            adj[src].add(dest);
            adj[dest].add(src);
            Edge edge=new Edge();
            edge.src=src;
            edge.dest=dest;
            edge.cost=cost;
            edges.add(edge);
        }

        Collections.sort(edges);
        List<Edge> mainEdges=edges;
        LinkedList<Integer> mainAdj[] = adj;


        for (int i = 0; i < V; i++) {

            end_loop = false;
            loop_count=0;
            edges=mainEdges;
            adj = mainAdj;
            min_Value=0;min_Cost=0;

            while (!end_loop)
                checkIfCyberAttackPossible(loop_count, 0);

            if(min_Value == main_min_Value)
                main_min_Cost = Math.min(min_Cost,main_min_Cost);
            else if(min_Value > main_min_Value){
                main_min_Value = min_Value;
                main_min_Cost = min_Cost;
            }

        }

        System.out.println(main_min_Value +"--" +main_min_Cost);



    }

    private static void checkIfCyberAttackPossible(int edge,int src) {

        //System.out.println("SrcVisited:-" +edges.get(edge).src +"--" +edges.get(edge).dest);

          boolean visited[]=new boolean[V];
          Arrays.fill(visited,false);
          int count=0;

        HashSet<Integer> queue=new HashSet<Integer>();
        queue.add(src);

        while (!queue.isEmpty()){

            int q_visited = queue.iterator().next();
            queue.remove(q_visited);
            visited[q_visited] = true;
            count++;


            Iterator<Integer> itr = adj[q_visited].listIterator();
            while (itr.hasNext()){
                int next=itr.next();
                if(!((edges.get(edge).src == q_visited || edges.get(edge).dest == q_visited) && (edges.get(edge).dest == next || edges.get(edge).src == next))
                        && !visited[next]){
                    queue.add(next);
                }
            }
        }

        if(count == V) {
            min_Cost += edges.get(edge).cost;
            if(min_Cost<=10) {
                //System.out.println(edges.get(edge).src +"--" +edges.get(edge).dest);
                int indexofSrc=adj[edges.get(edge).src].indexOf(edges.get(edge).dest);
                int indexofDest = adj[edges.get(edge).dest].indexOf(edges.get(edge).src);
                adj[edges.get(edge).src].remove(indexofSrc);
                adj[edges.get(edge).dest].remove(indexofDest);
                edges.remove(edge);
                min_Value++;
            }else {
                end_loop=true;
                min_Cost -= edges.get(edge).cost;
            }
        }else
            loop_count++;

        if(loop_count>=edges.size())
            end_loop = true;
    }


}
