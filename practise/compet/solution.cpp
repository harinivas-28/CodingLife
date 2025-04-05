#include <bits/stdc++.h> 
#define ll long long int
#define nl "\n"
#define pb push_back
#define ppb pop_back

#define FOR(x, y, z) for(int x=y;x<=z;x++)
#define RFOR(x, y, z) for(int x=y;x>=z;x--)
#define trav(x, v) for(auto &x: v)
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend() //reverse
#define sz(x) (int)(x).size()

#define F first
#define S second
#define pii pair<int, int>
#define pll pair<ll, ll>

#define MOD 1000000007
#define INF 1e9
#define EPS 1e-9
#define INFLL 1e18

#define NOD(x) ((int)log10(x)+1) // Number of digits

#define Fast()                              \
    ios_base::sync_with_stdio(false);       \
    cin.tie(NULL);                          \
    cout.tie(NULL);

using namespace std;

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

int main() {
    Fast();
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}