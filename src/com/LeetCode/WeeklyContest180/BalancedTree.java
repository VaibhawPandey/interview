package com.LeetCode.WeeklyContest180;

import java.util.Vector;

public class BalancedTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        new BalancedTree().balanceBST(treeNode);
    }


    public TreeNode balanceBST(TreeNode root) {
        Vector<TreeNode> nodes=new Vector<>();
        getINOrderNodes(root,nodes);

        int end=nodes.capacity();
        // root = buildTree(root,0,end);
        return root;
    }

//    private TreeNode buildTree(TreeNode root, int start, int end) {
//
//    }

    private void getINOrderNodes(TreeNode root, Vector<TreeNode> nodes) {
         if(root == null)
             return;

         getINOrderNodes(root.left,nodes);
         nodes.add(root);
         getINOrderNodes(root.right,nodes);
    }
}
