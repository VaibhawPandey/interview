package com.competitiveCodes.VPCodingBlocks.Graph;

public class UnionFindAlgoTemp {

    int V,E;
    Edge edge[];

    class Edge {
        int src,dest;
    }

    void Graph(int v,int e){
        this.V=v;
        this.E=e;
        edge = new Edge[E];

        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    private boolean isCycle() {

        int parent[]=new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = -1;

        for (int i = 0; i < E; i++) {

            int x=find(parent,edge[i].src);
            int y=find(parent,edge[i].dest);

            if(x==y)
                return true;

            parent = unionAll(parent,x,y);

        }

        return false;
    }

    private int[] unionAll(int[] parent, int x, int y) {

        int xSrc = find(parent,x);
        int yDest = find(parent,y);
        parent[yDest]=xSrc;

        return parent;
    }

    private int find(int[] parent, int i) {

        if(parent[i] == -1)
            return i;
        return find(parent,parent[i]);
    }

    public static void main(String[] args) {

        UnionFindAlgoTemp unionFindAlgoTemp=new UnionFindAlgoTemp();
        unionFindAlgoTemp.Graph(3,2);
        // add edge 0-1
        unionFindAlgoTemp.edge[0].src = 0;
        unionFindAlgoTemp.edge[0].dest = 1;

        // add edge 1-2
        unionFindAlgoTemp.edge[1].src = 1;
        unionFindAlgoTemp.edge[1].dest = 2;

        // add edge 0-2
       /* unionFindAlgoTemp.edge[2].src = 0;
        unionFindAlgoTemp.edge[2].dest = 2;*/

        if(unionFindAlgoTemp.isCycle())
            System.out.println("Cycle detected");
        else
            System.out.println("Cycle not detected");


    }


}
