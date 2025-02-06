package Coding.java;

import java.util.*;
/*
You are developing an application for a garden management system where each tree
in the garden is represented as a binary tree structure. The system needs to
allow users to plant new trees in a systematic way, ensuring that each tree is
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7



 */
public class Day6P4_Trees {
    private static List<Integer> res;
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] levelOrder = new int[n];
       for(int i=0;i<n;i++) levelOrder[i] = sc.nextInt();

       TreeNode root = buildTree(levelOrder, 0);
       res = new ArrayList<>();
       inorder(root);
       System.out.println(res);
       sc.close();
   }
   private static void inorder(TreeNode root){
       if(root==null) return;
       inorder(root.left);
       res.add(root.val);
       inorder(root.right);
   }
   private static TreeNode buildTree(int[] levelOrder, int idx){
       if(idx>=levelOrder.length) return null;
       TreeNode root = new TreeNode(levelOrder[idx]);
       root.left = buildTree(levelOrder, 2*idx+1);
       root.right = buildTree(levelOrder, 2*idx+2);
       return root;
   }
}