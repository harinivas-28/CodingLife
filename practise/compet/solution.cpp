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

string l = "abcdefghijklmnopqrstuvwxyz";
string u = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
string n = "0123456789";
void solve() {
    int a, b, c;
    cin >> a>> b>> c;
    int total = a+b+c;
    int ptr = 0;
    string res = "";
    while(total--){
        if(a){
            res += l[ptr%26];
            a--;
        }
        if(b){
            res += u[ptr%26];
            b--;
        }
        if(c){
            res += n[ptr%10];
            c--;
        }
        ptr++;
    }
    cout << res << endl;
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