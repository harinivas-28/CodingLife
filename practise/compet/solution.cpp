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

#define MOD 1e9+7
#define INF 1e9
#define EPS 1e-9
#define INFLL 1e18

#define NOD(x) ((int)log10(x)+1) // Number of digits

#define Fast()                              \
    ios_base::sync_with_stdio(false);       \
    cin.tie(NULL);                          \
    cout.tie(NULL);

ll gcd(ll a, ll b){
    return b==0?a:gcd(a%b, b);
}
ll lcm(ll a, ll b){
    return (a / gcd(a, b)) * b;
}
    
ll F(int a, int b){
    return lcm(a,b)/gcd(a,b);
}

bool isPrime(int x) {
    if (x <= 1) return false;
    if (x <= 3) return true;
    if (x % 2 == 0 || x % 3 == 0) return false;
    for (int i = 5; i * i <= x; i += 6) {
        if (x % i == 0 || x % (i + 2) == 0) return false;
    }
    return true;
}

using namespace std;

void solve(){
    int n;cin>>n;
    int x=0,y=0,sum=0;
    FOR(i,0,n-1){
        int t;cin>>t;
        if(t==1) x++;
        else y++;
        sum += t;
    }
    if(sum%2!=0){
        cout << "NO" << nl;
        return;
    }
    
}

int main()
{
	Fast();
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    ll t;
    cin >> t;
    while (t--) 
    solve();
}

