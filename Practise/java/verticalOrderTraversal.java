package Practise.java;

import Problems.java.ArrayUtils;
import Problems.java.BuildTree;
import Problems.java.TreeNode;

import java.util.*;

public class verticalOrderTraversal {

    static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    public static void dfs(TreeNode root, int col, int ht) {
        if (root == null) return;

        // Ensure TreeMap structure exists
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(ht, new PriorityQueue<>()); // Min-Heap for sorting
        map.get(col).get(ht).offer(root.val);

        dfs(root.left, col - 1, ht + 1);
        dfs(root.right, col + 1, ht + 1);
    }

    public static List<List<Integer>> orderTree(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> colValues : map.values()) {
            List<Integer> columnList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colValues.values()) {
                while (!pq.isEmpty()) columnList.add(pq.poll());
            }
            result.add(columnList);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
            TreeNode root = BuildTree.build(arr);
            List<List<Integer>> res = orderTree(root);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
