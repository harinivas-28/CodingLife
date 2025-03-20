package Coding.java;

import java.util.*;

public class Day10P1_flipTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        int levels = (int) Math.floor(Math.sqrt(arr.length+1));
        System.out.println(levels);
        TreeNode root = buildTree(arr);
        TreeNode res = flipTree(root);
        printTree(res);
        sc.close();
    }
    public static void printTree(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }
    // public static TreeNode buildFlipTree(TreeNode root, int levels){
    //     if(root==null) return null;
    //     TreeNode temp = dfs(root, levels);
    //     buildFlipTree(root.left, levels);
    //     buildFlipTree(root.right, levels);
    // }
    // public static TreeNode dfs(TreeNode root, int levels){
    //     if(levels==0) return new TreeNode(root.val);
    //     if(root.left!=null) dfs(root.left, levels-1);
    //     if(root.right!=null) dfs(root.right, levels-1);
    // }
    
    private static TreeNode buildTree(int[] vals){
        if (vals.length == 0 || vals[0] == -1) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(vals[0]);
        q.offer(root);

        int i = 1;
        while (i < vals.length) {
            TreeNode curr = q.poll();
            if (i < vals.length && vals[i] != -1) {
                curr.left = new TreeNode(vals[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < vals.length && vals[i] != -1) {
                curr.right = new TreeNode(vals[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static TreeNode flipTree(TreeNode root){
        if(root==null || root.left==null) return root;
        TreeNode latestRoot=flipTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=root.right=null;
        return latestRoot;
    }
}

