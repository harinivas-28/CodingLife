package practise.java;
import java.util.*;

import Coding.java.ArrayUtils;
public class subsequences {
    private static List<List<Integer>> ss = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        sc.close();
        generate(arr);
        List<List<Integer>> res = bitMask(arr);
        System.out.println(ss);
        System.out.println(res);
    }
    private static List<List<Integer>> bitMask(int[] arr){
        int n = arr.length;
        int total = 1<<n;
        List<List<Integer>> res = new ArrayList<>();
        for(int mask=0;mask<total;mask++){
            List<Integer> t = new ArrayList<>();
            for(int i=0;i<n;i++){
                // System.out.println(Integer.toBinaryString(mask)+" & "+Integer.toBinaryString(1<<i)+" = "+(mask&(1<<i)));
                if((mask&(1<<i))!=0){
                    t.add(arr[i]);
                }
            }
            res.add(t);
        }
        return res;
    }
    private static void generate(int[] nums){
        helper(nums, new boolean[nums.length], 0, new ArrayList<>());
    }
    private static void helper(int[] nums, boolean[] used, int st, List<Integer> curr){
        ss.add(new ArrayList<>(curr));
        for(int i=st;i<nums.length;i++){
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            helper(nums, used, i+1, curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
