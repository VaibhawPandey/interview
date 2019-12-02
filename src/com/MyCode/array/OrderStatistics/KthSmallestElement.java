package com.MyCode.array.OrderStatistics;

import java.util.Scanner;

public class KthSmallestElement {

    static int heapElements[];
    static int heap_size=0;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        heapElements=new int[n];
        for (int i = 0; i < n; i++)
            insertElement(scanner.nextInt());

        int k=scanner.nextInt();

        minHeap(k);
    }

    static int parent(int i){
        return (i-1)/2;
    }

    private static void insertElement(int element) {

        heapElements[heap_size]=element;
        heap_size++;

        int i=heap_size-1;
        while (i!=0 && heapElements[parent(i)]>heapElements[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }

    private static void swap(int src, int dest) {
        int temp=heapElements[src];
        heapElements[src]=heapElements[dest];
        heapElements[dest]=temp;
    }

    private static void minHeap(int k) {

        int minElement=-1;

        if(heap_size<k)
            System.out.println("Sufficient element");

        while (k!=0){
            minElement=extractMin();
            k--;
        }

        System.out.println(minElement);


    }

    private static int extractMin() {

        int root=heapElements[0];
        heapElements[0]=heapElements[heap_size-1];
        minHeapify(0);

        heap_size--;

        return root;
    }

    private static void minHeapify(int position) {

        int left=getLeftElement(position);
        int right=getRightElement(position);

        int smallest=position;
        if(left<heap_size && heapElements[left]<heapElements[smallest])
            smallest=left;
        if(right<heap_size && heapElements[right]<heapElements[smallest])
            smallest=right;

        if(smallest != position){
            swap(smallest,position);
            minHeapify(smallest);
        }

    }

    private static int getRightElement(int position) {
        return (2*position + 2);
    }

    private static int getLeftElement(int position) {
        return (2*position + 1); }



}
