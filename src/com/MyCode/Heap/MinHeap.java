package com.MyCode.Heap;

import java.util.Scanner;

public class MinHeap {

    static int heapElement[];
    static int capacity;
    static int heap_size=0;
    public static int parent(int i){ return (i-1)/2;}
    public static int left(int i){ return (2*i+1); }
    public static int right(int i){return (2*i+2); }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        capacity = scanner.nextInt();
        heapElement=new int[capacity];

        for (int i = 0; i < capacity; i++) {
            int element=scanner.nextInt();
            insertKey(element);
        }

        for (int i = 0; i < heap_size; i++)
            System.out.println(heapElement[i]);

        int keytobeDeleted = scanner.nextInt();
        deleteKey(keytobeDeleted);

        for (int i = 0; i < heap_size; i++)
            System.out.println(heapElement[i]);
    }

    private static void deleteKey(int keytobeDeleted) {
        decreaseKey(keytobeDeleted,Integer.MIN_VALUE);
        extractMin();
    }

    private static void extractMin() {
        if(heap_size<=0){
            System.out.println("No Element available to extract");
            return;
        }

        int root=heapElement[0];
        heapElement[0]=heapElement[heap_size-1];
        heap_size--;
        minHeapify(0);
    }

    private static void minHeapify(int index) {

        int left = left(index);
        int right = right(index);
        int smallest = index;

        if (left<heap_size && heapElement[left]<heapElement[smallest])
            smallest=left;
        if (right<heap_size && heapElement[right]<heapElement[smallest])
            smallest=right;

        if(smallest != index){
            swap(smallest,index);
            minHeapify(smallest);
        }
    }

    private static void decreaseKey(int keytobeDeleted, int newValue) {
        heapElement[keytobeDeleted] = newValue;

        while (keytobeDeleted != 0 && heapElement[parent(keytobeDeleted)]>heapElement[keytobeDeleted]){
            swap(parent(keytobeDeleted),keytobeDeleted);
            keytobeDeleted = parent(keytobeDeleted);
        }

        //heap_size--;
        System.out.println("KeyTBD:-" +keytobeDeleted);
    }

    private static void insertKey(int element) {

        if(heap_size == capacity)
            return;

        heap_size++;
        int position = heap_size-1;
        heapElement[position] = element;

        while (position != 0 && heapElement[parent(position)]>heapElement[position]){
            swap(parent(position),position);
            position = parent(position);
        }
    }

    private static void swap(int parentPosition, int position) {
        int temp=heapElement[position];
        heapElement[position] = heapElement[parentPosition];
        heapElement[parentPosition] = temp;
    }
}
