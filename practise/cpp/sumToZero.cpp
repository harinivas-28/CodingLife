#include<bits/stdc++.h>
using namespace std;
/*
Problem: Sum to 0
You're given an integer N. Your task is to construct an array A of size N such that:
Conditions:
The sum of all elements in the array is 0.
All elements in the array are non-zero integers.
The absolute value of each element is 1, 2, or 3 (i.e., |Ai| ∈ {1, 2, 3} for all i).
If it's not possible to construct such an array, output -1.
If multiple valid arrays exist, you may output any of them.

Input Format:
The first line contains a single integer T — the number of test cases.
The next T lines each contain a single integer N — the size of the array to construct.

Output Format:
For each test case, print N integers (space-separated) forming the required array, or print -1 if no such array exists.

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 50

Sample Input:
3
1
2
3
Sample Output:
-1
3 -3
1 2 -3
Explanation:
Test Case 1: No array of size 1 with non-zero elements can sum to 0 → output -1.
Test Case 2: Arrays like [3, -3], [1, -1], or [2, -2] are valid since they meet all conditions.
Test Case 3: Arrays like [1, 2, -3] or [2, -1, -1] are valid.
*/
int main(){
    int T;
    cin >> T;
    while(T--){
        int n; 
        cin >> n;
        if(n==1){
            cout << -1 << "\n";
            continue;
        }
        vector<int> res;
        if(n%2==0){
            for(int i=0;i<n;i++){
                if(i%2==0){
                    res.push_back(1);
                } else {
                    res.push_back(-1);
                }
            }
        } else {
            int sum = 0;
            for(int i=0;i<n-1;i++){
                if(i%2==0){
                    res.push_back(2);
                    sum += 2;
                } else {
                    res.push_back(-1);
                    sum -= 1;
                }
            }
            int last = -sum;
            if(last!=0 && abs(last)<=3){
                res.push_back(last);
            } else {
                cout << -1 << "\n";
                continue;
            }
        }
        for(auto& x: res)
            cout << x << " ";
        cout << "\n";
    }
}