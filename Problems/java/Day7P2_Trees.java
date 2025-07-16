package Problems.java;
/*
 Given the preorder and postorder traversals of a binary tree, construct
the original binary tree and print its level order traversal.

Input Format:
---------------
Space separated integers, preorder data
Space separated integers, post order data

Output Format:
-----------------
Print list of list of integers, the level-order data of the tree.


Sample Input:
----------------
1 2 4 5 3 6 7
4 5 2 6 7 3 1

Sample Output:
----------------
[[1], [2, 3], [4, 5, 6, 7]]

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4   5 6  7


Sample Input:
----------------
1 2 3
2 3 1

Sample Output:
----------------
[[1], [2, 3]]

Explanation:
--------------
    1
   / \
  2  3

 */
import java.util.*;
import java.util.stream.Collectors;

public class Day7P2_Trees {
    private static int preInd = 0;
    private static List<Integer> res;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> pre = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> post = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        TreeNode root = buildTree(pre, post);
        res = new ArrayList<>();
        inorder(root);
        System.out.println("In-Order: "+res);
        List<List<Integer>> lvl = levelOrder(root);
        System.out.println("Level Order: "+lvl);
        sc.close();
    }
    private static List<List<Integer>> levelOrder(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tempNode = q.poll();
                if(tempNode!=null){
                    temp.add(tempNode.val);
                    if(tempNode.left!=null) q.offer(tempNode.left);
                    if(tempNode.right!=null) q.offer(tempNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    private static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
    private static TreeNode buildTree(List<Integer> pre, List<Integer> post){
        return buildTreeHelper(pre, post, 0, post.size()-1);
    }
    private static TreeNode buildTreeHelper(List<Integer> pre, List<Integer> post, int start, int end){
        if(preInd >= pre.size() || start> end) return null;
        int rootVal = pre.get(preInd++); 
        TreeNode root = new TreeNode(rootVal);
        if(start==end) return root;
        int leftChild = pre.get(preInd);
        int idx = post.indexOf(leftChild);
        root.left = buildTreeHelper(pre, post, start, idx);
        root.right = buildTreeHelper(pre, post, idx+1, end-1);
        return root;
    }
}
