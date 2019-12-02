package com.MyCode.array.ArrayRearrangement;

public class ImpGetSortedArray {

    public static void main(String[] args) {
        int A[] = {10, 15, 25};
        int B[] = {1, 5, 20, 30};

        generate(A,B);
    }

    private static void generate(int[] A, int[] B) {
        int m=A.length;
        int n=B.length;

        int C[]=new int[m+n];

        generateinit(A,B,C,0,0,m,n,0,true);
    }

    private static void generateinit(int[] a, int[] b, int[] c, int i, int j, int m, int n, int len,boolean flag) {

        if(flag){

            if(len != 0)
               printArray(c,len+1);

            for (int k = i; k < m; k++) {

                if (len == 0){
                    c[len]=a[k];
                    generateinit(a,b,c,k+1,j,m,n,len,!flag);
                }else if(a[k]>c[len]){
                    c[len+1]=a[k];
                    generateinit(a,b,c,k+1,j,m,n,len+1,!flag);
                }

            }
        }else {

            for (int k = j; k < n; k++) {
                if(b[k]>c[len]) {
                    c[len + 1] = b[k];
                    generateinit(a,b,c,i,k+1,m,n,len+1,!flag);
                }
            }

        }

    }

    private static void printArray(int[] c, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(c[i] +" ");

        System.out.println();
    }
}
