package com.LeetCode.WeeklyContest156;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class RemoveAdjacentDup {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int k=scanner.nextInt();
        //System.out.println(removeDuplicates(str,k));
        System.out.println(removeDuplicatesSW(str,k));
    }

    private static String removeDuplicatesSW(String str, int k) {
        int n=str.length();
        int index=0;

        Stack<String> stack = new Stack<>();
        int lastCount=0;

        while (index<n){
            if(!stack.isEmpty()){
                String stringWithCount=stack.peek();
                if(str.charAt(index) == stringWithCount.charAt(0)){
                    int count=Integer.parseInt(String.valueOf(stringWithCount.substring(2,stringWithCount.length())))+1;
                    stack.push(String.valueOf(str.charAt(index) +"-" +count));
                    lastCount=count;
                }else {
                    stack.push(String.valueOf(str.charAt(index) +"-" +1));
                    lastCount=1;
                }

                if(lastCount == k){
                    for (int i = 0; i < k; i++)
                        stack.pop();
                }

                index++;
            }else {
                stack.push(String.valueOf(str.charAt(index) +"-" +1));
                lastCount=1;
                index++;
            }
        }

        String output=getOutput(stack);

        return output;
    }

    private static String getOutput(Stack<String> stack) {
        String output="";
         if(!stack.isEmpty())
        {
            String r = stack.pop();
            output=getOutput(stack);
            output += r.charAt(0);
        }

        return output;
    }

    public static String removeDuplicates(String s, int k) {

        MyLinkedList<Character> characterLinkedList=new MyLinkedList<>();

        for (int i = 0; i < s.length(); i++)
            characterLinkedList.push(s.charAt(i));

        int index=0,identicalIndex=1;

        boolean isUpdated=true;

        while (isUpdated){
            isUpdated = false;

            index=1;identicalIndex=1;
            while (index<characterLinkedList.size){
                if(characterLinkedList.get(index).equals(characterLinkedList.get(index-1)))
                    identicalIndex++;
                else
                    identicalIndex = 1;

                if(identicalIndex == k){
                    isUpdated = true;
                    characterLinkedList.remove(index-k+1,index);
                }
                index++;
            }
        }

        String output="";
        MyLinkedList temp=characterLinkedList.first;
        while (temp!=null) {
            output += temp.data;
            temp = temp.next;
        }

        return output;

    }

    static class MyLinkedList<E> {
        E data;
        MyLinkedList first=null;
        MyLinkedList previous;
        MyLinkedList next;
        MyLinkedList last;


        static int size=0;

        public void push(E data){
            MyLinkedList newNode=new MyLinkedList();
            newNode.data=data;
            newNode.previous=last;
            //newNode.next=null;
            if(first == null)
                first = newNode;
            if(last!=null)
            last.next=newNode;
            last = newNode;
            size++;
        }

        public E get(int index){
            int halfSize=size>>1;
            MyLinkedList temp=new MyLinkedList();
            if(index<halfSize){
                temp = first;
                for (int i = 0; i < index; i++)
                    temp = temp.next;
                return (E) temp.data;
            }else {
                temp=new MyLinkedList();
                temp=last;
                for (int i = size-1; i > index ; i--)
                    temp = temp.previous;
                return (E) temp.data;
            }
        }

        public void remove(int start, int end) {
            MyLinkedList temp=first;
            MyLinkedList newFirstNode=null;
            MyLinkedList newNode=new MyLinkedList();

            last = null;
            for (int i=0;i<size;i++){
                if(i<start || i>end){
                    newNode = new MyLinkedList();
                    newNode.data = temp.data;
                    newNode.previous=last;
                    if(last != null)
                        last.next = newNode;
                    if(newFirstNode == null)
                        newFirstNode = newNode;
                    last=newNode;
                }
                temp = temp.next;
            }

            size -= (end-start+1);

            if(newFirstNode != null)
            first=newFirstNode;
        }
    }
}
