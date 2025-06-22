package PYQ;
import Coding.java.ArrayUtils;

import java.util.*;
/*
A cybersecurity expert has just intercepted a transmission from a group of cybercriminals. The transmission contains an array arr of binary codes, which represents some confidential information. However, after a thorough analysis, the expert discovered a vulnerability in the encryption method. An array is considered to be compromised if the bitwise OR of all elements in the subarray is present in the array itself.

The goal is to find the number of compromised subarrays in the intercepted transmission and prevent the cybercriminals from exploiting this weakness in their encryption.

Note: A subarray is defined as any contiguous segment of the array.

Example

Given, n=3 and arr=[2,4,7].

Subarray	Bitwise OR	Is compromised?
2	2	Yes
2, 4	6	No
2, 4, 7	7	Yes
4	4	Yes
4, 7	7	Yes
7	7	Yes

Export to Sheets
Hence the answer is 5.

Function Description

Complete the function getCompromisedSubarrayCount in the editor below.

getCompromisedSubarrayCount takes the following arguments:
int arr[n]: the input array

Returns
long int: the number of compromised subarrays in the array
Constraints

1≤n≤10^5
1≤arr[i]≤10^6
 */
public class CompromisedSubarrayCount {
    private static long getCompromisedSubarrayCount(int[] arr){
        Set<Integer> set = new HashSet<>();
        long res = 0;
        for(int x: arr) set.add(x);
        for(int i=0;i<arr.length;i++){
            int bitOr = 0;
            for(int j=i;j<arr.length;j++){
                bitOr |= arr[j];
                if(set.contains(bitOr)) res++;
            }
        }
        return res;
    }
    private static long getCompromisedSubarrayCountOptim(int[] arr){
        Set<Integer> set = new HashSet<>();
        long res = 0;
        for(int x: arr) set.add(x);
        Set<Integer> prev = new HashSet<>();
        for(int x: arr){
            Set<Integer> curr = new HashSet<>();
            curr.add(x);
            for(int p: prev){
                curr.add(p | x);
            }
            for(int v: curr){
                if(set.contains(v)) res++;
            }
            prev = curr;
        }
        return res;
    }
    private static long getCompromisedXorSubarrayCountOptim(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int x: arr) set.add(x);
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        long res = 0;
        int prefixXor = 0;
        for(int num: arr){
            prefixXor ^= num;
            for(int v: set){
                int want = prefixXor^v;
                res += freq.getOrDefault(want, 0);
            }
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0)+1);
        }
        return res;
    }
    public static void main(String[] args){
        // int n;
        int[] arr = ArrayUtils.parseIntArray(new Scanner(System.in).nextLine());
        System.out.println("OR Brute Force: "+getCompromisedSubarrayCount(arr));
        System.out.println("OR Optimized: "+getCompromisedSubarrayCountOptim(arr));
        System.out.println("XOR Optimized: "+getCompromisedXorSubarrayCountOptim(arr));
    }
}
