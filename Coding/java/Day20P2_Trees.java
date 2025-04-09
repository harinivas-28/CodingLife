package Coding.java;
import java.util.*;
/*
Imagine you're the chief curator at a renowned museum that houses a rare collection 
of ancient artifacts. These artifacts are arranged in a special display that 
follows a strict rule: any artifact positioned to the left of another has a lower 
value, and any artifact on the right has a higher value. 

Your task is to transform this display into what is known as a "Greater Artifact 
Display." In this new arrangement, each artifact’s new value will be its original 
value plus the sum of the values of all artifacts that are more valuable than it.

Example 1:
----------
input=
4 2 6 1 3 5 7
output=
22 27 13 28 25 18 7

Explanation:
Input structure 
       4
      / \
     2   6
    / \ / \
   1  3 5  7

Output structure:
        22
      /   \
     27   13
    / \   / \
   28 25 18  7

Reverse updates:
- Artifact 7: 7
- Artifact 6: 6 + 7 = 13
- Artifact 5: 5 + 13 = 18
- Artifact 4: 4 + 18 = 22
- Artifact 3: 3 + 22 = 25
- Artifact 2: 2 + 25 = 27
- Artifact 1: 1 + 27 = 28


*/
public class Day20P2_Trees {
    // Build BST from level order input
    public static TreeNode buildTree(int[] arr){
        if(arr.length == 0 || arr[0] == -1) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            TreeNode curr = q.poll();
            if(i < arr.length && arr[i] != -1){
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;
            if(i < arr.length && arr[i] != -1){
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Global sum for reverse in-order traversal
    static int sum = 0;

    // Reverse in-order DFS to transform to Greater Tree
    private static TreeNode dfs(TreeNode root){
        if(root == null) return null;

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);

        return root;
    }

    // Print the tree in level order
    public static void levelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = buildTree(arr);
        TreeNode res = dfs(root);
        levelOrder(res);
        sc.close();
    }
}
