package com.practice.Interview.Program;

public class QueueLL {

    public static void main(String[] args) {

        MyLinkedList myLinkedList=new MyLinkedList();
        for (int i = 0; i < 8; i++)
            myLinkedList.push(i);

        for (int i = 0; i < 5; i++)
            System.out.print(myLinkedList.pop() +" ");

        System.out.println();

        for (int i = 0; i < 3; i++)
            System.out.print(myLinkedList.pop() +" ");
    }

    static class MyLinkedList{

        MyLinkedList first;
        MyLinkedList last;
        int data;
        MyLinkedList previous;
        MyLinkedList next;
        int size=0;


        public void push(int data){
            MyLinkedList newMyLL = new MyLinkedList();
            newMyLL.data = data;
            newMyLL.previous=last;
            newMyLL.next = null;
            if(first == null)
                first = newMyLL;
            if(last != null)
                last.next = newMyLL;
            last=newMyLL;
            size++;
        }

        public int pop(){
             if(size == 0)
                return 0;

             int data=first.data;
             first = first.next;
             if(first != null)
             first.previous = null;
             size--;
             return data;
        }


    }
}
