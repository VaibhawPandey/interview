package com.MyCode.Graph.BFSANDDFS.Hard;

import com.MyCode.Graph.BFSANDDFS.Graph;

import java.util.*;

/**
 * Ref:- https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/
 */
public class ShortestPathtoReachOnePrimetoOther {

    static List<Integer> allPrimeNumber = new ArrayList<>();
    static boolean isPrime[];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int u=scanner.nextInt(),v=scanner.nextInt();

        shortestPath(u,v);
    }

    private static void shortestPath(int u, int v) {
        int primeTillDigit = String.valueOf(v).length();
        int primeTill = 0;
        for (int i = 0; i < primeTillDigit; i++)
             primeTill = primeTill*10 + 9;
        System.out.println("PT:-" +primeTill);
        isPrime = new boolean[primeTill+1];
        Arrays.fill(isPrime,true);
        setAllPrimeNumber(primeTill);

        int indexofU=0,indexofV=0;

        Graph graph=new Graph(allPrimeNumber.size());
        for (int i = 0; i < allPrimeNumber.size(); i++) {
            if(allPrimeNumber.get(i) >= u) {
                if(allPrimeNumber.get(i) == u)
                    indexofU = i;
                if(allPrimeNumber.get(i) == v)
                    indexofV = i;
                for (int j = i + 1; j < allPrimeNumber.size(); j++) {
                      if(compare(allPrimeNumber.get(i),allPrimeNumber.get(j)))
                          graph.bidirectionalAddEdge(i,j);
                }
            }
        }

        bfsUtil(graph,indexofU,indexofV);

    }

    private static void bfsUtil(Graph graph,int indexofU,int indexofV) {

        int visited[]=new int[graph.V];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(indexofU);
        //visited[indexofU]++;
        int count=0;

        while (!queue.isEmpty()){
            int v=queue.poll();
            //visited[v] = true;
            if(v==indexofV)
                break;
            //count++;
            Iterator<Integer> itr=graph.adj[v].listIterator();
            while (itr.hasNext()){
                int r=itr.next();
                if(visited[r] == 0) {
                    queue.add(r);
                    visited[r] = visited[v] + 1;
                }
            }
        }

        System.out.println(visited[indexofV]);

    }

    private static boolean compare(Integer u, Integer v) {
        int count=0;
        int length=String.valueOf(u).length();

        for (int i = 1; i <=length; i++) {
            if(u%10 != v%10)
                count++;
            u /= 10;
            v /= 10;
        }

        return (count == 1);
    }

    private static void setAllPrimeNumber(int primeTill) {


        for (int p = 2; p*p <= primeTill; p++) {
            for (int i = p*p; i <= primeTill ; i += p) {
                isPrime[i]=false;
            }
        }

        for (int i = 1; i <= primeTill; i++) {
            if(isPrime[i])
                allPrimeNumber.add(i);
        }
    }
}
