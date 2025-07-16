package Practise.java;
import java.util.*;

import Problems.java.ArrayUtils;
import Problems.java.BuildTree;
import Problems.java.TreeNode;
public class lcaOfDeepestLeaves {
    static TreeMap<Integer, List<TreeNode>> map;
    static Map<TreeNode, TreeNode> pc;
    static class Pair {
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public static TreeNode lcaDeepestLeavesUsingDfs(TreeNode root) {
        return dfs(root).node;
    }
    private static Pair dfs(TreeNode root){
        if(root==null) return new Pair(null, 0);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        if(l.depth==r.depth){
            return new Pair(root, l.depth+1);
        } else if(l.depth>r.depth){
            return new Pair(l.node, l.depth+1);
        } else {
            return new Pair(r.node, r.depth+1);
        }
    }
    private static void bfs(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left==null && curr.right==null){
                    map.putIfAbsent(lvl, new ArrayList<>());
                    map.get(lvl).add(curr);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                    pc.put(curr.left, curr);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                    pc.put(curr.right, curr);
                }
            }
            lvl++;
        }
    }
    public static TreeNode findLca(TreeNode t1, TreeNode t2){
        if(t1==null || t2==null) return null;
        if(t1==t2) return t1;
        if(pc.get(t1)==pc.get(t2)) return pc.get(t1);
        return findLca(pc.get(t1), pc.get(t2));
    }
    public static TreeNode operate(){
        int key = map.lastKey();
        if(map.get(key).size()==1){
            return map.get(key).get(0);
        }
        List<TreeNode> l = map.get(key);
        TreeNode parent = l.get(0);
        for(int i=1;i<l.size();i++){
            parent = findLca(parent, l.get(i));
        }
        return parent;
    }
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        map = new TreeMap<>();
        pc = new HashMap<>();
        bfs(root);
        System.out.println(map);
        System.out.println(pc);
        return operate();
    }
    private static void inorder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        inorder(root.left);
        inorder(root.right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        TreeNode root = BuildTree.build(arr);
        TreeNode res = lcaDeepestLeaves(root);
        inorder(res);
        TreeNode res2 = lcaDeepestLeavesUsingDfs(root);
        inorder(res2);
        sc.close();
    }
}