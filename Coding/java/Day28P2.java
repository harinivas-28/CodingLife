package Coding.java;
import java.util.*;

/*
 * /*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
 where the length of A and B is same.
 
You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
 	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
 	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.
 
For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".
 
You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.
 
Input Format:
-------------
Three space separated strings, A , B and T
 
Output Format:
--------------
Print a string, relatively smallest string of T.
 
 
Sample Input-1:
---------------
kmit ngit mgit
 
Sample Output-1:
----------------
 ggit
 
Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"
 
 
Sample Input-2:
---------------
attitude progress apriori
 
Sample Output-2:
----------------
 aaogoog
 
 Explanation: 
 ------------
 The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
 the relatively smallest string of T is "aaogoog"
 */
public class Day28P2 {
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
        String[] arr = sc.nextLine().split(" ");
        String a = arr[0], b = arr[1],  tar = arr[2];

        DSU dsu = new DSU(26);
        for(int i=0;i<a.length();i++){
            int c1 = a.charAt(i)-'a', c2 = b.charAt(i)-'a';
            dsu.union(c1, c2);
        }
        System.out.println(dsu.toString());
        
        StringBuilder res = new StringBuilder();
        for(char c: tar.toCharArray()){
            char t = (char)(dsu.find(c-'a')+'a');
            res.append(t);
        }
        System.out.println(res.toString());
        sc.close();
    }
}
/*
 * private static Set<Integer> fun(int n){
        return new AbstractSet<>() {
            Set<Integer> res = null;
            private void build(){
                if(res!=null) return;
                res = new HashSet<>();
                for(int i=0;i<n;i++){
                    res.add(i);
                }
            }
            @Override
            public int size() {
                build();
                return res.size();
            }
            @Override
            public Iterator<Integer> iterator() {
                build();
		// return res.iterator();
                return new Iterator<>() {
                    int idx = 0;
                    @Override
                    public boolean hasNext() {
                        if(idx<res.size()) return true;
                        return false;
                    }
                    @Override
                    public Integer next() {
                        return idx++;
                    }
                };
            }
        };
    }
 */
