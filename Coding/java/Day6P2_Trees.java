package Coding.java;
import java.util.*;
/*
In a distant future, humanity has begun interstellar colonization, establishing
zones of habitation and control on a new planet. Scientists have recorded two
types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how
the colonization started, with the first zone established and then expanding
into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows
how zones were positioned relative to each other on the map, based on
territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy
(binary tree of zones) and analyze areas within a specific range of levels.
However, due to security concerns, patrol teams will scan these zones in a
zigzag pattern:
    - Odd levels (starting from 1) should be inspected from left to right.
    - Even levels should be inspected from right to left.

Input Format:
-------------
An integer N representing the number of zones colonized.
N space-separated integers representing the Planetary Layout Order (in-order).
N space-separated integers representing the Survey Order (pre-order).
Two space sepaarted integers,Lower Level (L), Upper Level (U)

Output Format:
--------------
Print all zone IDs within the specified levels, but in spiral order:
    - Odd levels → Left to Right.
    - Even levels → Right to Left.

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7
2 3

Sample Output:
--------------
3 2 4 5 6 7

Explanation:
------------
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond
to the following colonization hierarchy:

        1
       / \
      2   3
     / \  / \
    4   5 6  7

Levels 2 to 3 in Regular Order:
Level 2 → 2 3
Level 3 → 4 5 6 7

Spiral Order:
Level 2 (Even) → 3 2 (Right to Left)
Level 3 (Odd) → 4 5 6 7 (Left to Right)


 */
public class Day6P2_Trees {
    private static int preInd;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for(int i=0;i<n;i++) in.add(sc.nextInt());
        for(int i=0;i<n;i++) pre.add(sc.nextInt());
        int a = sc.nextInt();
        int b = sc.nextInt();
        TreeNode root2 = buildTree2(in, pre);
        List<Integer> res2 = levelOrder(root2, a, b);
        System.out.println(res2);
        sc.close();
    }
    private static TreeNode buildTree2(List<Integer> in, List<Integer> pre){
        preInd = 0;
        return buildTreeHelper2(in, pre, 0, in.size()-1);
    }
    private static TreeNode buildTreeHelper2(List<Integer> in, List<Integer> pre, int start, int end){
        if(start > end) return null;
        int rootVal = pre.get(preInd++);
        TreeNode root = new TreeNode(rootVal);
        int idx = in.indexOf(rootVal);
        root.left = buildTreeHelper2(in, pre, start, idx-1);
        root.right = buildTreeHelper2(in, pre, idx+1, end);
        return root;
    }
    private static List<Integer> levelOrder(TreeNode root, int a, int b){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> zag = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp != null){
                    if(level >= a && level <= b) zag.add(temp.val);
                    if(temp.left != null) q.offer(temp.left);
                    if(temp.right != null) q.offer(temp.right);
                }
            }
            if(level >= a && level <= b){
                if(level % 2 == 0){
                    Collections.reverse(zag);
                }
                res.addAll(zag);
            }
            level++;
        }
        return res;
    }
}
class TreeNode {
    TreeNode left = null;
    TreeNode right = null;
    int val;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

