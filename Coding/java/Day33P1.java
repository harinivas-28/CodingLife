package Coding.java;
import java.util.*;

public class Day33P1 {
    static int m = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 0, g=0, i =0, j=n-1;
        while(i<=j){
            if(x>=nums[i]){
                g++;
                x-=nums[i++];
            } else if(g>=1){
                g--;
                x+=nums[j--];
            }
            res = Math.max(res, g);
        }
        System.out.println(res);
        sc.close();
    }
}