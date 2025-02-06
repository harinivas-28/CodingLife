package Coding.java;

import java.util.*;
/*
In a distant galaxy, an ancient civilization built a hierarchical communication
network of interconnected relay stations. The structure of this network can be
reconstructed using two ancient data logs:
    - Beacon Activation Order (analogous to in-order traversal)
    - Final Signal Sent Order (analogous to post-order traversal)

Using these logs, we can reconstruct the original relay network and process
queries about signals reaching specific hierarchical levels.

Given the Beacon Activation Order and the Final Signal Sent Order of a galactic
communication network, reconstruct the relay network. After reconstructing
the hierarchy, and the output should list the relay stations in the order they
appear in a level-wise transmission sequence.

Input Format:
-------------
- An integer N representing the number of relay stations in the network.
- A space-separated list of N integers representing the Beacon Activation Order
    (similar to in-order traversal).
- A space-separated list of N integers representing the Final Signal Sent Order
    (similar to post-order traversal).

Output Format:
--------------
A list of integers, level-wise transmission sequence.


Sample Input:
-------------
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
Sample Output:
---------------
[1, 2, 3, 4, 5, 6, 7]


Explanation:
The logs correspond to the following hierarchical relay network:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
The level order is : 1 2 3 4 5 6 7

 */
public class Day6P1_Trees {
    private static int postInd;
    private static Map<Integer, Integer> map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        for(int i=0;i<n;i++) in.add(sc.nextInt());
        for(int i=0;i<n;i++) post.add(sc.nextInt());
//        TreeNode root = buildTree(in, post);
        TreeNode root2 = buildTree2(in, post);
//        List<Integer> res = levelOrder(root);
        List<Integer> res2 = levelOrder(root2);
//        System.out.println(res);
        System.out.println(res2);
    }
    private static TreeNode buildTree2(List<Integer> in, List<Integer> post){
        postInd = post.size()-1;
        return buildTreeHelper2(in, post, 0, postInd);
    }
    private static TreeNode buildTreeHelper2(List<Integer> in, List<Integer> post, int start, int end){
        // Check this
        // Without using map ._.
        if(start>end) return null;
        int rootVal = post.get(postInd--);
        TreeNode root = new TreeNode(rootVal);
        int idx = findInd(in, rootVal, start, end);
        root.right = buildTreeHelper2(in, post, idx+1, end);
        root.left = buildTreeHelper2(in, post, start, idx-1);
        return root;
    }
    private static int findInd(List<Integer> in, int target, int start, int end){
        for(int i=start;i<=end;i++){
            if(in.get(i)==target){
                return i;
            }
        }
        return -1;
    }
    private static List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
//        res.add(root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp!=null){
                    res.add(temp.val);
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
        }
        return res;
    }
    private static TreeNode buildTree(List<Integer> in, List<Integer> post) {
        /*
            7
            4 2 5 1 6 3 7 <- in
            4 5 2 6 7 3 1 <- post
         */
        postInd = post.size()-1;
        map = new HashMap<>();
        for(int i=0;i<in.size();i++){
            map.put(in.get(i), i);
        }
        return buildTreeHelper(post, 0, postInd);
    }
    private static TreeNode buildTreeHelper(List<Integer> post, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = post.get(postInd--);
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        root.right = buildTreeHelper(post, idx+1, end);
        root.left = buildTreeHelper(post, start, idx-1);
        return root;
    }
}

