package Practise.java;
import java.util.*;

public class flipTree {
    static class TreeNode {
        TreeNode left =  null, right = null;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = buildTree(arr);
        printLevelOrder(root);
        System.out.println();
        TreeNode res = _flipTree(root);
        printLevelOrder(res);
        sc.close();
    }
    private static void printLevelOrder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.print(curr.val+" ");
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
        }
    }
    private static TreeNode buildTree(int[] vals){
        if(vals.length==0 || vals[0]==-1) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(vals[0]);
        q.offer(root);
        int i =1;
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
    private static TreeNode _flipTree(TreeNode root){
        if(root==null || root.left==null) return root;
        TreeNode latestRoot=_flipTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=root.right=null;
        return latestRoot;
    }
}
