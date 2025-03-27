package Coding.java;
import java.util.*;
public class Day16P3_Trees {
    private static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int t = dfs(0, a);
        System.out.println(res+" "+t);
        sc.close();
    }
    private static int dfs(int idx, int[] a){
        if(idx>=a.length) return 0;
        int s = dfs(2*idx+1, a) + dfs(2*idx+2, a);
        int sum = (2*idx+1<a.length)?a[2*idx+1]:0 + ((2*idx+2<a.length)?a[2*idx+2]:0);
        if(sum==a[idx]){
            res += s;
        }
        return res;
    }
}

