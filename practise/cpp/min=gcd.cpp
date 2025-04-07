/*
# Problem B. MIN = GCD

## Time Limit: 1 second
## Memory Limit: 256 megabytes

You are given a positive integer sequence a of length n. Determine if it is possible to rearrange a such that there exists an integer i (1≤i<n) satisfying:

min([a₁, a₂, …, aᵢ]) = gcd([aᵢ₊₁, aᵢ₊₂, …, aₙ])

Here gcd(c) denotes the greatest common divisor of c, which is the maximum positive integer that divides all integers in c.

## Input
Each test contains multiple test cases. The first line contains the number of test cases t (1≤t≤10⁴). The description of the test cases follows.

The first line of each test case contains a single integer n (2≤n≤10⁵).

The second line contains n integers a₁, a₂, …, aₙ (1≤aᵢ≤10¹⁸).

It is guaranteed that the sum of n over all test cases does not exceed 10⁵.

## Output
For each test case, output "Yes" if it is possible, and "No" otherwise.

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.

## Example

### Input
```
7
2
1 1
2
1 2
3
2 2 3
3
2 3 4
5
4 5 6 9 3
3
998244359987710471 99824435698771045 1000000007
6
1 1 4 5 1 4
```

### Output
```
Yes
No
Yes
No
Yes
Yes
Yes
```

## Note
In the first test case, rearrange a to [1,1] and let i=1, then min([1])=gcd([1]).

In the second test case, it can be shown that it is impossible.

In the third test case, rearrange a to [3,2,2] and let i=2, then min([3,2])=gcd([2]).

In the fifth test case, rearrange a to [3,4,5,6,9] and let i=3, then min([3,4,5])=gcd([6,9]).
*/
#include<bits/stdc++.h>
#define ll long long
using namespace std;

void solve(){
    ll n;
    cin >> n;
    ll a[n];
    for(int i=0;i<n;i++) cin >> a[i];

    sort(a, a+n);
    vector<ll> op;
    for(ll i=1;i<n;i++){
        if(a[i]%a[0]==0){
            op.push_back(a[i]);
        }
    }
    if(op.size()==0){
        cout << "No" << endl;
        return;
    }
    ll g = op[0];
    for(ll i=1;i<op.size();i++){
        g = __gcd(g, op[i]);
    }
    if(g==a[0]){
        cout << "Yes";
    } else {
        cout << "No";
    }
    cout << endl;
}

int main(){
    ios::sync_with_stdio(false); 
    cin.tie(nullptr); 
    cout.tie(nullptr);

    ll t;
    cin >> t;
    while(t--)
        solve();
}