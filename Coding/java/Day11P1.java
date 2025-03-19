package Coding.java;

import java.util.*;

public class Day11P1 {
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
        if(root1!=null && root2!=null && root1.val!=root2.val) return false;
        if(root1==null || root2==null) return root1==null && root2==null;
        return checkTree(root1.left, root2.right) && checkTree(root1.right, root2.left);
    }
}
