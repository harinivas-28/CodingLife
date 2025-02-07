package Coding.java;
/*
 Given the preorder and postorder traversals of a binary tree, construct
the original binary tree and print its level order traversal.

Input Format:
---------------
Space separated integers, preorder data
Space separated integers, post order data

Output Format:
-----------------
Print list of list of integers, the level-order data of the tree.


Sample Input:
----------------
1 2 4 5 3 6 7
4 5 2 6 7 3 1

Sample Output:
----------------
[[1], [2, 3], [4, 5, 6, 7]]

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4   5 6  7


Sample Input:
----------------
1 2 3
2 3 1

Sample Output:
----------------
[[1], [2, 3]]

Explanation:
--------------
    1
   / \
  2  3

 */
import java.util.*;
public class Day7P2_Trees {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] pre = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] post = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree(pre, post);
    }
    private static TreeNode buildTree(int[] pre, int[] post){
        return null;
        // TODO : Implement this function tomorrow
    }
}
