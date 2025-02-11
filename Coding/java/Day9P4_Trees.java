package Coding.java;

import java.util.*;
/*
The Indian Army has established multiple military camps at strategic locations
along the Line of Actual Control (LAC) in Galwan. These camps are connected in
a hierarchical structure, with a main base camp acting as the root of the network.

To fortify national security, the Government of India has planned to deploy
a protective S.H.I.E.L.D. that encloses all military camps forming the outer
boundary of the network.

Structure of Military Camps:
    - Each military camp is uniquely identified by an integer ID.
    - A camp can have at most two direct connections:
        - Left connection → Represents a subordinate camp on the left.
        - Right connection → Represents a subordinate camp on the right.
    - If a military camp does not exist at a specific position, it is
      represented by -1

Mission: Deploying the S.H.I.E.L.D.
Your task is to determine the list of military camp IDs forming the outer
boundary of the military network. This boundary must be traversed in
anti-clockwise order, starting from the main base camp (root).

The boundary consists of:
1. The main base camp (root).
2. The left boundary:
    - Starts from the root’s left child and follows the leftmost path downwards.
    - If a camp has a left connection, follow it.
    - If no left connection exists but a right connection does, follow the right connection.
    - The leftmost leaf camp is NOT included in this boundary.
3. The leaf camps (i.e., camps with no further connections), ordered from left to right.
4. The right boundary (in reverse order):
    - Starts from the root’s right child and follows the rightmost path downwards.
    - If a camp has a right connection, follow it.
    - If no right connection exists but a left connection does, follow the left connection.
    - The rightmost leaf camp is NOT included in this boundary.


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]


Sample Input-3:
---------------
1 2 3 -1 -1 -1 5 -1 6 7

Sample Output-3:
----------------
[1, 2, 7, 6, 5, 3]


 */

public class Day9P4_Trees {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] vals = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = buildTree(vals);
        
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val); 
            leftBoundary(root.left, result);
            addLeaves(root, result); 
            rightBoundary(root.right, result); 
        }

        System.out.println(result);
        sc.close();
    }

    private static void leftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!(node.left == null && node.right == null)) { 
                result.add(node.val);
            }
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private static void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private static void rightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!(node.left == null && node.right == null)) { 
                temp.add(node.val);
            }
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }

    private static TreeNode buildTree(int[] vals){
        if (vals.length == 0 || vals[0] == -1) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(vals[0]);
        q.offer(root);

        int i = 1;
        while (i < vals.length) {
            TreeNode curr = q.poll();
            if (i < vals.length && vals[i] != -1) {
                curr.left = new TreeNode(vals[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < vals.length && vals[i] != -1) {
                curr.right = new TreeNode(vals[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}

