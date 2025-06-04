/*
Write a Java program to convert a decimal number to binary using both
1. Recursive method
2. Iterative method

Implement the methods in Solution class and return the binary number.

Sample Input:
---------------
10

Sample Output:
------------------
Binary (Recursive): 1010
Binary (Iterative): 1010

*/

class Solution {
    public static String decimalToBinaryRecursive(int n) {
        // Implement the method recursively
        if(n==0) return "0";
        if(n==1) return "1";
        return decimalToBinaryRecursive(n/2) + (n%2);
    }

    public static String decimalToBinaryIterative(int n) {
        // Implement the method iteratively
        StringBuilder res = new StringBuilder();
        while(n>0){
            res.append((n&1));
            n>>=1;
        }
        return res.reverse().toString();
    }
}