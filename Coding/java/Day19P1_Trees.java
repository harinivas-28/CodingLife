package Coding.java;
import java.util.*;
/*
Imagine you are a librarian organizing books on vertical shelves in a grand library. The books are currently scattered across a tree-like structure, where each book (node) has a position determined by its shelf number (column) and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Example 1:
Input:
3 9 20 -1 -1 15 7
Output: 
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Example 2:
Input:
3 9 8 4 0 1 7
Output: 
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.

*/
public class Day19P1_Trees {
    private static TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> map;
    private static void dfs(TreeNode root, int col, int ht){
        if(root==null) return;
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(ht, new LinkedList<>());
        map.get(col).get(ht).offer(root.val);
        dfs(root.left, col-1, ht+1);
        dfs(root.right, col+1, ht+1);
    }
    private static List<List<Integer>> verticalOrderTraversal(TreeNode root){
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> r = new ArrayList<>();
        for(TreeMap<Integer, Queue<Integer>> k: map.values()){
            List<Integer> z = new ArrayList<>();
            for(Queue<Integer> pq: k.values()){
                while(!pq.isEmpty()) z.add(pq.poll());
            }
            r.add(z);
        }
        return r;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = BuildTree.build(arr);
        List<List<Integer>> r = verticalOrderTraversal(root);
        List<List<Integer>> r2 = verticalTraversal(root);
        System.out.println(r);
        System.out.println(r2);
        sc.close();
    }
    static class Pair {
        TreeNode node;
        int verLevel;
        Pair(){}
        Pair(TreeNode node,int verLevel){
            this.node = node;
            this.verLevel = verLevel;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Pair p = new Pair(root, 0);
        Queue<Pair> q = new LinkedList<>();
        q.offer(p);
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        tm.put(0, new ArrayList<>());
        tm.get(0).add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair t = q.poll();
                if(t.node.left!=null){
                    Pair l = new Pair(t.node.left, t.verLevel-1);
                    q.offer(l);
                    tm.putIfAbsent(l.verLevel, new ArrayList<>());
                    tm.get(l.verLevel).add(l.node.val);
                }
                if(t.node.right!=null){
                    Pair r = new Pair(t.node.right, t.verLevel+1);
                    q.offer(r);
                    tm.putIfAbsent(r.verLevel, new ArrayList<>());
                    tm.get(r.verLevel).add(r.node.val);
                }
            }
        }
        return new ArrayList<>(tm.values());
    }
}
