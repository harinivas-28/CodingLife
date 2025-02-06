//import java.util.*;
//
//public class Day1P1_SW {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int l = sc.nextInt();
//        int r = sc.nextInt();
//        sc.nextLine();
//        int[] nums = Arrays.stream(sc.nextLine().split(" "))
//                        .limit(N)
//                        .mapToInt(Integer::parseInt)
//                        .toArray();
//        int res = Integer.MAX_VALUE;
//        // For window len l to r;
//        for(int i=l;i<=r;i++){
//            int prod = 1;
//            for(int j=0;j<i;j++){
//                prod*=nums[j];
//                // System.out.println("Prod1: "+prod);
//            } // window product
//            res = prod>0 ? Math.min(res, prod) : res;
//            for(int j=1;j<=N-i;j++){
//                prod /= nums[j-1];
//                prod*=nums[j+i-1];
//                // System.out.println(prod);
//                res = (prod>0) ? Math.min(res, prod) : res;
//            }
//        }
//        res = res==Integer.MAX_VALUE ? -1 : res;
//        System.out.println(res);
//        sc.close();
//    }
//}
// import java.util.*;

// class Day5P1_SW {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int l = sc.nextInt();
//         int r = sc.nextInt();
//         sc.nextLine();
//         int[] nums = Arrays.stream(sc.nextLine().split(" "))
//                         .limit(N)
//                         .mapToInt(Integer::parseInt)
//                         .toArray();
//         int res = Integer.MAX_VALUE;
//         // For window len l to r;
//         for(int i=l;i<=r;i++){
//             int prod = 1;
//             for(int j=0;j<i;j++){
//                 prod*=nums[j];
//                 // System.out.println("Prod1: "+prod);
//             } // window product
//             res = prod>0 ? Math.min(res, prod) : res;
//             for(int j=1;j<=N-i;j++){
//                 // Zero Case
//                 // if(nums[j+i-1]==0){
//                 //     j += i;
//                 //     continue;
//                 // }
//                 prod /= nums[j-1];
//                 prod*=nums[j+i-1];
//                 // System.out.println(prod);
//                 res = (prod>0) ? Math.min(res, prod) : res;
//             }
//         }
//         res = res==Integer.MAX_VALUE ? -1 : res;
//         System.out.println(res);
//     }
// }
package Coding;
 import java.util.*;

public class Day1P1_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        int min = Integer.MAX_VALUE;
        for(int k=0;k<=(r-l+1);k++){
            int curr = 1;
            for(int i=0;i<n;i++){
                curr *= nums[i];
                if(i>=l-1){
                    if(curr>0){
                        min = Math.min(min, curr);
                    }
                    if(nums[i-l+1]==0) continue;
                    curr /= nums[i-l+1];
                }
            }
            l++;
        }
        System.out.println(min==Integer.MAX_VALUE ? -1 : min);
    }
}
