package Coding.java;
import java.util.*;

public class buildTree {
    public buildTree() {
        inorder = new ArrayList<>();
    }
    public static TreeNode createTree(List<Integer> levelOrder){
        if(levelOrder.isEmpty() || levelOrder.get(0)==-1) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder.get(0));
        q.offer(root);

        int i = 1;
        while(i < levelOrder.size()){
            TreeNode curr = q.poll();
            if(i< levelOrder.size() && levelOrder.get(i)!=-1){
                curr.left = new TreeNode(levelOrder.get(i));
                q.offer(curr.left);
            }
            i++;
            if(i<levelOrder.size() && levelOrder.get(i)!=-1){
                curr.right = new TreeNode(levelOrder.get(i));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    private static List<Integer> inorder;
    public static List<Integer> getInorder(TreeNode root){
        inorderTraverse(root);
        return inorder;
    }
    private static void inorderTraverse(TreeNode root){
        if(root==null) return;
        inorderTraverse(root.left);
        inorder.add(root.val);
        inorderTraverse(root.right);
    }
}
