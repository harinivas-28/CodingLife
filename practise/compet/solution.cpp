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
int countCute(vector<int>& a) {
    int n = a.size();
    int ans = 0;

    for (int center = 0; center < n; ++center) {
        int i = center, j = center;

        // Strictly increasing to the left
        while (i > 0 && a[i - 1] < a[i]) i--;

        // Strictly decreasing to the right
        while (j + 1 < n && a[j] > a[j + 1]) j++;

        // Length of bitonic subarray
        int len = j - i + 1;
        if (len >= 2) {
            // Every subarray from i to j with center at 'center' is cute
            ans += (len * (len + 1)) / 2 - (len - 1); // Count of all subarrays - non bitonic parts
        }
    }

    return ans;
}

void solve() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int& x : a) cin >> x;
    cout << countCute(a) << "\n";
}

int main() {
    Fast();
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    
    ll t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}