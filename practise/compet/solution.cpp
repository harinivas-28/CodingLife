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

string getKey(int x) {
    int t = x;
    int freq[10] = {0};
    // count digits of x
    while (x > 0) {
        freq[x % 10]++;
        x /= 10;
    }
    x = t+1;
    while (x > 0) {
        freq[x % 10]++;
        x /= 10;
    }
    string key = "";
    FOR(i, 0, 9){
        key += string(freq[i], '0' + i);
    }
    return key;
}
void solve() {
    int n;
    cin >> n;
    set<string> set;
    FOR(i, 1, n){
        string s = getKey(i);
        set.insert(s);
    }
    cout << set.size() << nl;
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