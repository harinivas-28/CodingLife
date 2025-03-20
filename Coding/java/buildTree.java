package Coding.java;
import java.util.*;

public class buildTree {
    public static TreeNode build(int[] vals){
        if(vals.length==0 || vals[0]==-1) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(vals[0]);
        q.offer(root);
        int i = 1;
        while(i<vals.length){
            TreeNode curr = q.poll();
            if(i<vals.length && vals[i]!=-1){
                curr.left = new TreeNode(vals[i]);
                q.offer(curr.left);
            }
            i++;
            if(i<vals.length && vals[i]!=-1){
                curr.right = new TreeNode(vals[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static int height(TreeNode root, int s){
        return getHt(root, s, 0);
    }
    private static int getHt(TreeNode root, int s, int ht){
        if(root==null) return -1;
        if(root.val==s) return ht;
        int leftHt = getHt(root.left, s, ht+1);
        if(leftHt!=-1){
            return leftHt;
        }
        return getHt(root.right, s, ht+1);
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
        inorder = new ArrayList<>();
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
