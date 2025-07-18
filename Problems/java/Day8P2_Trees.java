package Problems.java;
import java.util.*;
/*
 * In an Intelligence Agency, each senior officer supervises either two junior officers 
or none. The senior officer is assigned a clearance level equal to the lowest clearance 
level of the two junior officers they supervise.

The clearance levels are represented as integer values in the range [1, 50], and multiple 
officers may have the same clearance level.

At the end, all officers (senior and junior) are collectively referred to as agents in the system.

You are provided with a hierarchical clearance level tree where each node represents 
an officer's clearance level. The tree structure follows these rules:
	- If a node has two children, its clearance level is the minimum of the two children's
	  clearance levels.
	- If a node has no children, it's clearance level is same as exists.
	- The value -1 indicates an empty (null) position.
Your task is to find the highest clearance level among all agents in the agency. 
If no such level exists, return -2.

Input Format:
-------------
A single line of space separated integers, clearance levels of each individual.

Output Format:
--------------
Print an integer, the highest clearance level.


Sample Input-1:
---------------
2 5 2 -1 -1 2 4

Sample Output-1:
----------------
5


Sample Input-2:
---------------
3 3 3 3 3

Sample Output-2:
----------------
3

 */
public class Day8P2_Trees {
    private static int res = Integer.MIN_VALUE;
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int[] vals = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree(vals, 0);
        inorder(root);
        System.out.println(res);
        sc.close();
    }
    private static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        res = Math.max(res, root.val);
        inorder(root.right);
    }
    private static TreeNode buildTree(int[] vals, int level){
        if(level>=vals.length) return null;
        if(vals[level]==-1) return null;
        TreeNode root = new TreeNode(vals[level]);
        root.left = buildTree(vals, 2*level+1);
        root.right = buildTree(vals, 2*level+2);
        return root;
    }
}
