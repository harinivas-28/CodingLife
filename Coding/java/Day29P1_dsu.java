package Coding.java;
import java.util.*;

public class Day29P1_dsu {
    static class DSU {
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y){
            int rx = find(x), ry = find(y);
            if(rx!=ry){
                if(rx<ry) parent[ry] = rx;
                else parent[rx] = ry;
            }
        }
        public String toString(){
            return Arrays.toString(parent);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String tar = sc.next();
        DSU dsu = new DSU(26);
        for(int i=0;i<a.length();i++){
            int c1 = a.charAt(i)-'a', c2 = b.charAt(i)-'a';
            dsu.union(c1, c2);
        }
        StringBuilder res = new StringBuilder();
        for(char c: tar.toCharArray()){
            char t = (char)(dsu.find(c-'a')+'a');
            res.append(t);
        }
        System.out.println(res.toString());
        sc.close();
    }
}