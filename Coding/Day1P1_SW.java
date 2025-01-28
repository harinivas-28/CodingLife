import java.util.*;

public class Day1P1_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                        .limit(N)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int res = Integer.MAX_VALUE;
        // For window len l to r;
        for(int i=l;i<=r;i++){
            int prod = 1;
            for(int j=0;j<i;j++){
                prod*=nums[j];
                // System.out.println("Prod1: "+prod);
            } // window product
            res = prod>0 ? Math.min(res, prod) : res;
            for(int j=1;j<=N-i;j++){
                prod /= nums[j-1];
                prod*=nums[j+i-1];
                // System.out.println(prod);
                res = (prod>0) ? Math.min(res, prod) : res; 
            }
        }
        res = res==Integer.MAX_VALUE ? -1 : res;
        System.out.println(res);
        sc.close();
    }
}
