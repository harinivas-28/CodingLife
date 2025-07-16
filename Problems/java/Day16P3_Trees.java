package Problems.java;
import java.util.*;
/*
There are some pages in a website, each page links with atmost two other pages.
Each page displays a number on it. The complete website is given as binary tree 
using the level order insertion technique.

You need to return the number of pages where the number in the page is equal to 
the sum of the numbers of its descendants. A descendant refers to any page that 
is linked but lower down the tree stucture of the website, no matter how many 
levels lower.

Input Format:
-------------
Single line of comma separated integers, numbers displayed in web-pages as Tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
11 3 5 2 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
3 2 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
For the pages diplaying the number 0: The sum of descendants is 0,
since they have no descendant pages.

*/
public class Day16P3_Trees {
    private static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        dfs(0, a);
        System.out.println(res);
        sc.close();
    }
    private static int dfs(int idx, int[] a){
        if(idx>=a.length) return 0;
        int leftSum = dfs(2*idx+1, a);
        int rightSum = dfs(2*idx+2, a);
        int sum = leftSum + rightSum;
        if (sum>0 && sum == a[idx]){
            res++;
        }
        return sum + a[idx];
    }
}

