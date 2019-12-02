package com.LeetCode.WeeklyContest151;

import javafx.util.Pair;

import java.util.*;

public class ZeroSum {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        Integer input[]={0};
        ListNode head=null;
        ListNode tempHead=null;
        for (int i = 0; i < input.length; i++){
            if (head == null) {
                    head = new ListNode(input[i]);
                    tempHead = head;
                } else {
                    head.next = new ListNode(input[i]);
                    head = head.next;
                }
        }

        head = tempHead;

        head = removeZeroSumSublists(head);

        while (head != null){
            System.out.print(head.val +" ");
            head = head.next;
        }
    }

    private static ListNode createListNode(ListNode head,List<Integer> input,List<Integer> incPosition) {

        ListNode tempHead=null;
        for (int i = 0; i < input.size(); i++){
            if(!incPosition.contains(i)) {
                if (head == null) {
                    head = new ListNode(input.get(i));
                    tempHead = head;
                } else {
                    head.next = new ListNode(input.get(i));
                    head = head.next;
                }
            }
        }

        head = tempHead;

        return head;
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode outputHead=null;
        List<Integer> input=new ArrayList<>();

        while (head != null){
             input.add(head.val);
             head = head.next;
         }

        int minPosition=Integer.MAX_VALUE;
        List<Range> rangeList=new ArrayList<>();
        List<Integer> inclPosition=new ArrayList<>();

        if(input.size()==1 && input.get(0) == 0) {
            inclPosition.add(0);
            return createListNode(head, input, inclPosition);
        }


        for (int i = input.size()-1; i >= 0; i--) {
            int sum=input.get(i);
            for (int j = i-1; j >= 0; j--) {
                sum += input.get(j);
                if(sum == 0)
                    minPosition = Math.min(minPosition,j);
            }

            if(minPosition != Integer.MAX_VALUE) {
                Pair<Integer,Integer> pair=new Pair<>(minPosition,i);
                int range=i-minPosition+1;
                rangeList.add(new Range(pair,range));
            }
        }

        Collections.sort(rangeList);
        List<String> inclusiveRange=new ArrayList<>();

        for (int i=rangeList.size()-1;i>= 0;i--) {
            Range range=rangeList.get(i);
            boolean isInclusive = false;
            for (String inc:inclusiveRange){
                if(range.rangePair.getKey()>= Integer.valueOf(inc.split("-")[0]) || range.rangePair.getKey()<=Integer.valueOf(inc.split("-")[0]))
                    isInclusive = true;
                if(range.rangePair.getValue()>= Integer.valueOf(inc.split("-")[1]) || range.rangePair.getValue()<=Integer.valueOf(inc.split("-")[1]))
                    isInclusive = true;
            }

            if(!isInclusive)
                inclusiveRange.add(range.rangePair.getKey() +"-" +range.rangePair.getValue());
        }


        for (String inc:inclusiveRange){
            String incPos[]=inc.split("-");
            for (int i = Integer.valueOf(incPos[0]); i <= Integer.valueOf(incPos[1]); i++) {
                inclPosition.add(i);
            }
        }


        outputHead = createListNode(outputHead,input,inclPosition);
        return outputHead;
    }

    static class Range implements Comparable{

        Pair<Integer,Integer> rangePair;
        Integer range;

        public Range(Pair<Integer, Integer> rangePair, Integer range) {
            this.rangePair = rangePair;
            this.range = range;
        }

        @Override
        public int compareTo(Object obj) {
            return this.range.compareTo(((Range)obj).range);
        }
    }
}


