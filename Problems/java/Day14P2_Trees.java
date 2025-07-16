package Problems.java;

import java.util.*;

public class Day14P2_Trees {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a1 = ArrayUtils.parseIntArray(sc.nextLine());
        int[] a2 = ArrayUtils.parseIntArray(sc.nextLine());
        TreeNode r1 = BuildTree.build(a1);
        TreeNode r2 = BuildTree.build(a2);
        TreeNode r3 = new Day14P2_Trees().combinedReport(r1, r2);
        List<Integer> l = new Day14P2_Trees().levelOrder(r3);
        System.out.println(l);
        sc.close();
    }
    public TreeNode combinedReport(TreeNode root1, TreeNode root2){
        // Implement the logic
        if(root1==null && root2==null) return null;
        if(root1==null) return root2;
        else if(root2==null) return root1;
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = combinedReport(root1.left, root2.left);
        root.right = combinedReport(root1.right, root2.right);
        return root;
    }
    public List<Integer> levelOrder(TreeNode root){
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                res.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        return res;
    }
}

/*
TreeNode for Reference.

class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}
*/

