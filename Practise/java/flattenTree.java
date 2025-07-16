package Practise.java;
import java.util.*;
import Problems.java.TreeNode;
import Problems.java.ArrayUtils;
import Problems.java.BuildTree;
public class flattenTree {
    // For printing
    private static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static TreeNode prev = null;
    private static void flatten(TreeNode root){
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        TreeNode root = BuildTree.build(arr);
        preOrder(root);
        System.out.println();
        flatten(root);
        preOrder(root);
        sc.close();
    }
}
