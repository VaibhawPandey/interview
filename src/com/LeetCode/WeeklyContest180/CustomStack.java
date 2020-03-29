package com.LeetCode.WeeklyContest180;

public class CustomStack {

    int size = -1;
    int arr[];

    public static void main(String[] args) {
       CustomStack customStack=new CustomStack(3);
        customStack.push(3);
        customStack.push(4);
        System.out.println(customStack.pop());
        customStack.push(5);
        customStack.push(6);
        customStack.increment(2,200);
        customStack.increment(5,100);
        System.out.println(customStack.pop() +" " +customStack.pop() +" " +customStack.pop() +" " +customStack.pop());
    }

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
         if(size<arr.length){
             size++;
             arr[size] = x;
         }
    }

    public int pop() {
        if(size < 0)
            return -1;

        size--;
        return arr[size+1];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < arr.length; i++)
            arr[i] += val;
    }
}
