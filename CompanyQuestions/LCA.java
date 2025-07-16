package CompanyQuestions;
// AMAZON Q
// DO MAXIMUM DEPTH OF A BINARY TREE USING DFS AND BFS
// DO LIS (LONGEST INCREASING SUBSEQUENCE) PROBLEM
public class LCA {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l!=null && r!=null) return root;
        return (l!=null)?l:r;
    }
    public static void main(String[] args) {
        // Example tree:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left.left;      // 6
        TreeNode q = root.right;     // 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
