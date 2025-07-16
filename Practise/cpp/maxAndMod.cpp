/*
# Problem A. Max and Mod

## Time Limit: 1 second
## Memory Limit: 256 megabytes

You are given an integer n. Find any permutation p of length n such that:
* For all 2 ≤ i ≤ n, max(p_i-1, p_i) mod i = i-1 is satisfied.

If it is impossible to find such a permutation p, output -1.

**Note:** 
* A permutation of length n is an array consisting of n distinct integers from 1 to n in arbitrary order. For example, [2,3,1,5,4] is a permutation, but [1,2,2] is not a permutation (2 appears twice in the array), and [1,3,4] is also not a permutation (n=3 but there is 4 in the array).
* x mod y denotes the remainder from dividing x by y.

## Input
Each test contains multiple test cases. The first line contains the number of test cases t (1 ≤ t ≤ 99). The description of the test cases follows.

The first line of each test case contains a single integer n (2 ≤ n ≤ 100).

## Output
For each test case:
* If such a permutation p doesn't exist, output a single integer -1.
* Otherwise, output n integers p_1, p_2, ..., p_n — the permutation p you've found. If there are multiple answers, output any of them.

## Example

### Input
```
4
2
3
4
5
```

### Output
```
-1
3 2 1
-1
1 5 2 3 4
```

## Note
In the first test case, it is impossible to find such a permutation p, so you should output -1.

In the fourth test case, p=[1,5,2,3,4] satisfies the condition:
* For i=2, max(p_1, p_2) = 5 and 5 mod 2 = 1.
* For i=3, max(p_2, p_3) = 5 and 5 mod 3 = 2.
* For i=4, max(p_3, p_4) = 3 and 3 mod 4 = 3.
* For i=5, max(p_4, p_5) = 4 and 4 mod 5 = 4.
*/

#include<iostream>
using namespace std;

void solve(){
    int n;
    cin >> n;
    if(n%2==0){
        cout << -1 << endl;
        return;
    } else {
        for(int i=0;i<n;i++){
            if(i==0) cout << n << " ";
            else cout << i << " ";
        }
    }
    cout << endl;
}

int main(){
    int t;
    cin >> t;
    while(t--)
        solve();
}

// BRUTE FORCE
/*
// Function to check if the permutation satisfies the condition
bool check(const vector<int>& p) {
    for (int i = 2; i <= p.size(); i++) {
        if (max(p[i-2], p[i-1]) % i != i - 1) {
            return false;
        }
    }
    return true;
}

// DFS to search for a valid permutation
bool dfs(int n, vector<int>& curr, vector<bool>& used, vector<int>& result) {
    // If we've built a complete permutation
    if (curr.size() == n) {
        if (check(curr)) {
            result = curr;
            return true;
        }
        return false;
    }
    
    // Try each number from 1 to n
    for (int i = 1; i <= n; i++) {
        if (!used[i]) {
            // Early check to prune the search
            if (curr.size() >= 1) {
                int idx = curr.size() + 1; // 1-indexed position we're filling
                if (idx >= 2 && max(curr.back(), i) % idx != idx - 1) {
                    continue; // Skip this value, it can't work
                }
            }
            
            used[i] = true;
            curr.push_back(i);
            
            if (dfs(n, curr, used, result)) {
                return true;
            }
            
            curr.pop_back();
            used[i] = false;
        }
    }
    
    return false;
}
void solve() {
    int n;
    cin >> n;
    
    vector<int> curr, result;
    vector<bool> used(n + 1, false);
    
    bool found = dfs(n, curr, used, result);
    
    if (!found) {
        cout << -1 << endl;
    } else {
        for (int x : result) {
            cout << x << " ";
        }
        cout << endl;
    }
}
*/