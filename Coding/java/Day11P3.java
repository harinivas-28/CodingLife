package Coding.java;
import java.util.*;

public class Day11P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        int s = sc.nextInt();
        int d = sc.nextInt();

        TreeNode root = buildTree.build(arr);
        int htS = buildTree.height(root, s);
        int htD = buildTree.height(root, d);
        int lca = findLca(root, s, d);
        int htLca = buildTree.height(root, lca);

        int dist = (htS+htD)-(2*htLca);
        System.out.println("Distance from source "+s+" to destination "+d+" = "+dist);
        sc.close();
    }
    public static int findLca(TreeNode root, int s, int d){
        if(root==null) return -1;
        if(root.val==s || root.val==d) return root.val;
        
        int left = findLca(root.left, s, d);
        int right = findLca(root.right, s, d);
        if(left!=-1 && right!=-1) return root.val;
        
        return (left!=-1) ? left : right;
    }
}
