#include<bits/stdc++.h>
using namespace std;
/*
Problem: Numbers and Strings

Description:
For each integer x from 1 to n, we form the string S(x) according to the following rules:
1. Compute (x + 1).
2. Write x and (x + 1) next to each other in the decimal system without separators or leading zeros.
3. In the resulting string, sort all digits in non-decreasing order.

For example:
- The string S(139) is "011349" (before sorting, it is "139140").
- The string S(99) is "00199".

Task:
Count the number of distinct strings among S(1), S(2), ..., S(n).

Input:
- The first line contains one integer t (1 ≤ t ≤ 10^4) — the number of test cases.
- Each test case consists of one line containing a single integer n (1 ≤ n ≤ 10^9 - 2).

Output:
- For each test case, output a single integer — the number of distinct strings among S(1), S(2), ..., S(n).

Example:
Input:
2
42
1337

Output:
42
948

Explanation for the first input (n = 42):
For x = 1, we compute 1 and 2 → 12 → sorting digits → 12
For x = 2, 2 and 3 → 23 → sorted → 23
...
All strings are different for x from 1 to 42, so the answer is 42.
For larger n like 1337, some strings become same after sorting, so the answer is less than 1337, and here it is 948.
*/
int main(){
    int t=1;
    // cin >> t;
    while(t--){
        int n;
        cin >> n;
        
    }
}