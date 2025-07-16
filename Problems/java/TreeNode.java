package Problems.java;

public class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    public int val;

    public TreeNode(int val){
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
    public String toString(){
        return ""+this.val;
    }
}
