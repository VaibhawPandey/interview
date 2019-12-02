package com.competitiveCodes.VPCodingBlocks.Graph;

public class FloodFillAlgo {

    static int M=8,N=8;
    static int screen[][];

    public static void main(String[] args) {

        screen=new int[M][N];

        screen = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;

        int prevC=screen[x][y];
        floodFill(screen,x,y,newC,prevC);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(screen[i][j] +" ");
            }
            System.out.println();
        }

    }

    private static void floodFill(int[][] screen, int x, int y, int newC,int prevC) {

          if(x < 0 | x >= M | y < 0 | y >= N)
              return;

          if(screen[x][y] != prevC)
              return;

          screen[x][y] = newC;

          floodFill(screen,x+1,y,newC,prevC);
          floodFill(screen,x,y+1,newC,prevC);
          floodFill(screen,x-1,y,newC,prevC);
          floodFill(screen,x,y-1,newC,prevC);


    }
}
