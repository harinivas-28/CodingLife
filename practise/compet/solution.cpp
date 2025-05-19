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

void solve() {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    int res = 0;
    while(n*m>1){
        int d1 = m-a, d2 = n-b;
        if(m>n){
            n -= d2>=b-1 ? d2 : b-1;
        } else {
            m -= d1>=a-1 ? d1 : a-1;
        }
        res++;
    }
    cout << res << nl;
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