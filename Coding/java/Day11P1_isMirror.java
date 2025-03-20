package Coding.java;
/*
Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend 
Anil to check whether the BT is a self-mirror tree or not.

Can you help Rakesh determine whether the given BT is a self-mirror tree?
Return true if it is a self-mirror tree; otherwise, return false.

Note:
------
In the tree, '-1' indicates an empty (null) node.

Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
*/ 
import java.util.*;

public class Day11P1_isMirror {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree.build(arr);
        boolean res = checkTree(root, root);
        System.out.println(res);
        sc.close();
    }
    private static boolean checkTree(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return false;
        if(root1==null || root2==null) return true;
        if(root1.val!=root2.val) return false;
        return checkTree(root1.left, root2.right) && checkTree(root1.right, root2.left);
    }
}
