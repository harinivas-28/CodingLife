package practise.java;
import java.util.*;

import Coding.java.ArrayUtils;
public class knapsack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] wts = ArrayUtils.parseIntArray(sc.nextLine());
        int[] vals = ArrayUtils.parseIntArray(sc.nextLine());
        int limit = sc.nextInt();
        int res = recurse(wts, vals, limit, 0, 0);
        System.out.println("Recursive: "+res);
    }
    private static int recurse(int[] wts, int[] vals, int limit, int currWt, int idx){
        if(idx>=wts.length) return currWt;
        return 0;
    }
}
