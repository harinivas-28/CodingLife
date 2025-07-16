package Problems.java;

import java.util.*;

/*
Write a program to construct a binary tree from level-order input, while treating -1
as a placeholder for missing nodes. The program reads input, constructs the tree,
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indicates null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7

====================================
 */
public class Day7P1_Trees {
    private static List<Integer> res;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] lvl = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree(lvl, 0);
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
    private static TreeNode buildTree(int[] lvl, int idx){
        if(idx>=lvl.length) return null;
        if(lvl[idx]==-1) return null;
        TreeNode root = new TreeNode(lvl[idx]);
        // 1 2 3 4 5 6 7
        root.left = buildTree(lvl, 2*idx+1);
        root.right = buildTree(lvl, 2*idx+2);
        return root;
    }
}
