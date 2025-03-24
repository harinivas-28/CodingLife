#include <bits/stdc++.h> 
#define ll long long int
#define nl "\n"
#define pb push_back
#define ppb pop_back
#define Fast()                              \
    ios_base::sync_with_stdio(false);       \
    cin.tie(NULL);                          \
    cout.tie(NULL);
    
using namespace std;
ll mod = 1e9+7;

void solve(){
    int n; cin >> n;
	int v[n];
	for(int i=1;i<n;i++) cin >> v[i];
	vector<int> res;
	res.pb(n);
	int curr = v[n-1];
	while(curr!=1){
		res.pb(curr);
		curr = v[curr-1];
	}
	res.pb(1);
	for(int i=res.size()-1;i>=0;i--){
		cout << res[i] << " ";
	}
	cout << nl;
}

int main()
{
	Fast();
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    // ll t;
    // cin >> t;
    // while (t--) 
    solve();
}

