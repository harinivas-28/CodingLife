/*
 *In a distant future, humanity has begun interstellar colonization, establishing 
zones of habitation and control on a new planet. Scientists have recorded two 
types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how 
the colonization started, with the first zone established and then expanding 
into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows 
how zones were positioned relative to each other on the map, based on 
territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy 
(binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
1 2 3 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]

 */
package Problems.java;

import java.util.*;

public class Day6P5_Trees {
    private static int preInd;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for(int i=0;i<n;i++) in.add(sc.nextInt());
        for(int i=0;i<n;i++) pre.add(sc.nextInt());

        TreeNode root = buildTree(in, pre);
        List<Integer> res = levelOrder(root);
        System.out.println(res);
        sc.close();
    }
    private static List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp!=null){
                    res.add(temp.val);
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
        }
        return res;
    }
    private static TreeNode buildTree(List<Integer> in, List<Integer> pre){
        preInd = 0;
        return buildTreeHelper(in, pre, 0, in.size()-1);
    }
    private static TreeNode buildTreeHelper(List<Integer> in, List<Integer> pre, int start, int end){
        if(start>end) return null;
        int val = pre.get(preInd++);
        TreeNode root = new TreeNode(val);
        int idx = in.indexOf(root.val);
        root.left = buildTreeHelper(in, pre, start, idx-1);
        root.right = buildTreeHelper(in, pre, idx+1, end);
        return root;
    }
}