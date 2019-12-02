package com.MyCode.Heap;

import java.util.Scanner;

public class MinHeapTemp1 {

    static int heapElement[];
    static int capacity;
    static int heap_size=0;
    public static int parent(int i){ return (i-1)/2;}
    public static int left(int i){ return (2*i+1)/2;}
    public static int right(int i){return (2*i+2)/2;}

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        capacity = n;
        heapElement = new int[capacity];

        for (int i = 0; i < capacity; i++)
            insertKey(scanner.nextInt());

        for (int i = 0; i < capacity; i++)
            System.out.println(heapElement[i]);

        int key=scanner.nextInt();
        deleteKey(key);

        for (int i = 0; i < capacity; i++)
            System.out.println(heapElement[i]);

    }

    private static void deleteKey(int key) {

        int pos=0;
        while (heapElement[pos] != key)
            pos++;

        heapElement[pos] = heapElement[capacity-1];
        minHeapify(pos);
        capacity--;
    }

    private static void minHeapify(int index) {


        int smaller = index;
        if(left(smaller) < capacity && right(smaller) < capacity) {
            if (smaller != 0 && heapElement[left(smaller)] < heapElement[smaller])
                smaller = left(smaller);
            if (smaller != 0 && heapElement[right(smaller)] < heapElement[smaller])
                smaller = right(smaller);

            if (smaller != index) {
                int temp = heapElement[smaller];
                heapElement[smaller] = heapElement[index];
                heapElement[index] = temp;
                minHeapify(smaller);
            }
        }

    }

    private static void insertKey(int element) {

        int position=heap_size;
        heapElement[heap_size]  = element;
        heap_size++;

        while (position != 0 && heapElement[parent(position)]>heapElement[position]){
            int temp=heapElement[position];
            heapElement[position] = heapElement[parent(position)];
            heapElement[parent(position)] = temp;
            position = parent(position);
        }
    }
}
