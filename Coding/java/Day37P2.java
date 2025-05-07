package Coding.java;
import java.util.*;
/*
 *  Mr Manoj is given a special device, which performs either mutliply by 2 
and subtract by 1. He is given an intial value I.
He wants to get a value V using the special device.

Your task is to help Mr Manoj to get the value V from I, in mimimum steps.
The steps are 1). multiply by 2
2). subtract by 1. 

Input Format:
-------------
Two space separated integers, I and V

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5 8

Sample Output-1:
----------------
2

Explanation:
------------
Perform Substraction, now I = 4
Perform Multiplication, now I = 8


Sample Input-2:
---------------
3 10

Sample Output-2:
----------------
3

Explanation:
------------
Perform Multiplication, now I = 6
Perform Substraction, now I = 5
Perform Multiplication, now I = 10
 */
public class Day37P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int I = sc.nextInt(), V = sc.nextInt();
        sc.close();
        System.out.println(solve(I, V));
    }
    private static int solve(int I, int V){
        int steps = 0;
        while (V > I) {
            if (V % 2 == 0) {
                V /= 2; 
            } else {
                V += 1; 
            }
            steps++;
        }
        return steps + (I - V); 
    }
}
