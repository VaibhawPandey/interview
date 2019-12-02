package com.competitiveCodes.VPCodingBlocks.Graph;

public class UnionFindAlgo {

       int V,E;
       Edge edge[];

       class Edge{
           int src,dest;
       }

       void Graph(int v,int e){
           this.V=v;
           this.E=e;
           edge = new Edge[E];

           for (int i = 0; i < E; i++)
               edge[i] = new Edge();

       }

    private int find(int[] parent, int src) {

           if(parent[src] == -1)
               return src;

           return find(parent,parent[src]);
    }

    private boolean isCycle(UnionFindAlgo unionFindAlgo) {

           int parent[]=new int[unionFindAlgo.V];

           for (int i = 0; i < unionFindAlgo.V; i++)
              parent[i] = -1;

        for (int i = 0; i < unionFindAlgo.E ; i++) {

            int xsrc = find(parent,unionFindAlgo.edge[i].src);
            int ydest = find(parent,unionFindAlgo.edge[i].dest);

            if(xsrc == ydest)
                return true;

            parent=unionFindAlgo.unionAlgo(parent,xsrc,ydest);
        }

        return false;
    }

    private int[] unionAlgo(int[] parent, int xsrc, int ydest) {
           int x=find(parent,xsrc);
           int y=find(parent,ydest);
           parent[x]=y;

           return parent;
    }


    public static void main(String[] args) {

        int V = 3, E = 3;
        UnionFindAlgo unionFindAlgo = new UnionFindAlgo();

        unionFindAlgo.Graph(V,E);
        // add edge 0-1
        unionFindAlgo.edge[0].src = 0;
        unionFindAlgo.edge[0].dest = 1;

        // add edge 1-2
        unionFindAlgo.edge[1].src = 1;
        unionFindAlgo.edge[1].dest = 2;

        // add edge 0-2
        unionFindAlgo.edge[2].src = 0;
        unionFindAlgo.edge[2].dest = 2;

        if(unionFindAlgo.isCycle(unionFindAlgo))
            System.out.println("Cycle exist");
        else
            System.out.println("Cycle does not exist");

    }


}
