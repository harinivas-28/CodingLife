package Problems.java;

import java.util.*;

/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch.
Each branch may also have sub branches. For example release 3-5-4 refers to the
fourth checkin in the fifth sub branch of the third main branch.
This hierarchy can go upto any number of levels.

If a level is missing it is considered as level 0 in that hierarchy.
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0.
The higher numbers denote more recent releases.

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/
public class Day64P1 {
    private static int[] parse(String v){
        String[] parts = v.split("-");
        List<Integer> nums = new ArrayList<>();
        for(String p: parts) nums.add(Integer.parseInt(p));
        // Trim trailing zeros
        int i = nums.size()-1;
        while(i>0 && nums.get(i)==0) i--;
        return nums.subList(0, i+1).stream().mapToInt(x->x).toArray();
    }
    private static boolean isGreater(String v1, String v2){
        int[] arr1 = parse(v1);
        int[] arr2 = parse(v2);
        int n = Math.max(arr1.length, arr2.length);
        for(int i=0;i<n;i++){
            int num1 = i<arr1.length ? arr1[i]:0;
            int num2 = i<arr2.length ? arr2[i] : 0;
            if(num1 > num2) return true;
            else if(num1 < num2) return false;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] versions = sc.nextLine().trim().split(" ");
        String latest = versions[0];
        for(int i=1;i<versions.length;i++){
            if(isGreater(versions[i], latest)){
                latest = versions[i];
            }
        }
        System.out.println(trimTrailingZeros(latest));
    }
    private static String trimTrailingZeros(String v){
        int[] parts = parse(v);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<parts.length;i++){
            if(i>0) sb.append("-");
            sb.append(parts[i]);
        }
        return sb.toString();
    }
}
