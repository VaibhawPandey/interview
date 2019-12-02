package com.MyCode.array.ArrayRotation;

public class RotateSublistfromPosition {

    public static class ListNode{
        int data;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head =push(head, 70);
        head =push(head, 60);
        head =push(head, 50);
        head =push(head, 40);
        head =push(head, 30);
        head =push(head, 20);
        head =push(head, 10);
        ListNode tmp = head;
        System.out.print("Given List: ");
        while (tmp != null) {
            System.out.print( tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();

        int m = 3, n = 6, k = 2;
        System.out.print( "After rotation of sublist: ");
        rotateSubList(head, m, n, k);
    }

    private static void rotateSubList(ListNode head, int m, int n, int k) {


    }

    private static ListNode push(ListNode head, int n) {

        ListNode listNode=new ListNode();
        listNode.data = n;
        listNode.next = head;
        head = listNode;
        return head;

    }
}
