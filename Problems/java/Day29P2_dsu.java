package Problems.java;
import java.util.*;
/*
 * You are a database integrity engineer working for a global cloud company. 
Your team maintains a distributed database network, where each server either:
    - Stores equivalent data to another server (serverX == serverY).
    - Stores different data from another server (serverX != serverY).

The transitive consistency rule must be followed:
    - If A == B and B == C, then A == C must be true.
    - If A == B and B != C, then A != C must be true.

Your task is to analyze the given constraints and determine whether they 
follow transitive consistency. If all relations are consistent, return true; 
otherwise, return false

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false

Explanation:
------------
{a, b} form one equivalence group.
{c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
However, b != c contradicts b == a and c == a.

Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true

 */
public class Day29P2_dsu {
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
                parent[ry] = rx;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("\\s+");
        sc.close();
        DSU dsu = new DSU(26);
        for(String s: arr){
            if(s.substring(1, 3).equals("==")){
                dsu.union(s.charAt(0)-'a', s.charAt(3)-'a');
            }
        }
        for(String s: arr){
            if(s.substring(1, 3).equals("!=")){
                int p1 = dsu.find(s.charAt(0)-'a'), p2 = dsu.find(s.charAt(3)-'a');
                if(p1==p2){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
}

