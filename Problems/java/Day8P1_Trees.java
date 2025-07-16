package Problems.java;
/*
Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend
Anil to check whether the BT is a self-mirror tree or not.

Can you help Anil determine whether the given BT is a self-mirror tree?
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

public class Day8P1_Trees {
//    private static int level = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vals = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree(vals, 0);
//        List<Integer> res = levelOrder(root);
//        System.out.println(res);
        boolean res = checkMirror(root, root);
        System.out.println(res);
        sc.close();
    }
    private static boolean checkMirror(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        boolean l =  checkMirror(left.left, right.right);
        boolean r = checkMirror(left.right, right.left);
        return l && r;
    }
    private static TreeNode buildTree(int[] vals, int level){
        if(level>=vals.length) return null;
        if(vals[level]==-1) return null;
        TreeNode root = new TreeNode(vals[level]);
        root.left = buildTree(vals, 2*level+1);
        root.right = buildTree(vals, 2*level+2);
        return root;
    }
}
