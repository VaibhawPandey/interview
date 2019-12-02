package com.competitiveCodes.VPCodingBlocks.Graph;

public class UnionFindRankAlgo {

      class Edge{
          int src,dest;
      }

      int V,E;
      Edge edge[];

      void Graph(int v,int e){
          this.V=v;
          this.E=e;
          edge = new Edge[E];

          for (int i = 0; i < E; i++)
              edge[i] = new Edge();
      }

      class subset{
          int parent,rank;
      }

    public static void main(String[] args) {

          UnionFindRankAlgo unionFindRankAlgo=new UnionFindRankAlgo();
          unionFindRankAlgo.Graph(3,3);

        // add edge 0-1
        unionFindRankAlgo.edge[0].src = 0;
        unionFindRankAlgo.edge[0].dest = 1;

        // add edge 1-2
        unionFindRankAlgo.edge[1].src = 1;
        unionFindRankAlgo.edge[1].dest = 2;

        // add edge 0-2
        unionFindRankAlgo.edge[2].src = 0;
        unionFindRankAlgo.edge[2].dest = 2;

        if(unionFindRankAlgo.isCycle())
            System.out.println("Cycle detected");
        else
            System.out.println("Cycle not detected");

    }

    private boolean isCycle() {

        subset subsetList[]=new subset[V];
        for (int i = 0; i < V; i++) {
            subsetList[i] = new subset();
            subsetList[i].parent = i;
            subsetList[i].rank = 0;
        }

        for (int i = 0; i < E; i++) {

            int x=find(subsetList,edge[i].src);
            int y=find(subsetList,edge[i].dest);

            if(x==y)
                return true;

            Union(subsetList,edge[i].src,edge[i].dest);

        }

        return false;
    }

    private void Union(subset[] subsetList, int src, int dest) {

          int xSrc=find(subsetList,src);
          int yDest=find(subsetList,dest);

          if(subsetList[xSrc].rank < subsetList[yDest].rank)
              subsetList[xSrc].parent=yDest;
          else if(subsetList[xSrc].rank > subsetList[yDest].rank)
              subsetList[yDest].parent = xSrc;
          else {
              subsetList[yDest].parent=xSrc;
              subsetList[xSrc].rank++;
          }
    }

    private int find(subset[] subsetList, int i) {

        if(subsetList[i].parent != i)
            return find(subsetList,subsetList[i].parent);

        return subsetList[i].parent;
    }
}
