package practise.java;

import java.util.*;
import Coding.java.ArrayUtils;
import Coding.java.TreeNode;
import Coding.java.buildTree;

public class recoverTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        TreeNode root = buildTree.build(arr);
        // bruteForce(root);
        {
            swapNodes(root);
            int temp = first.val;
            first.val = sec.val;
            sec.val = temp;
        }
        levelOrder(root);
        sc.close();
    }
    private static List<Integer> it;
    private static int index = 0;
    @SuppressWarnings("unused")
    private static void bruteForce(TreeNode root){
        it = new ArrayList<>();
        inorder(root);
        Collections.sort(it);
        swap(root);
    }
    private static void swap(TreeNode root){
        if(root == null) return;
        swap(root.left);
        if(root.val != it.get(index)) root.val = it.get(index);
        index++;
        swap(root.right);
    }
    private static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        it.add(root.val);
        inorder(root.right);
    }
    private static void levelOrder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                System.out.print(curr.val+" ");
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        System.out.println();
    }
    private static TreeNode first = null, sec = null, prev = null;
    private static void swapNodes(TreeNode root){
        if(root==null) return;
        swapNodes(root.left);
        if(prev!=null && prev.val>=root.val){
            if(first==null) first = root;
            sec = root;
        }
        swapNodes(root.right);
    }
}
