#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int res = 0;
int dfs(int node, vector<int> arr[]){
    if(arr[node].size()==0) return 1;
    int val = 0;
    for(const auto& num: arr[node]){
        val = max(val, dfs(num, arr));
    }
    return val + 1;
}
void solve() {
    int n; cin >> n;
    vector<int> arr[n+1];
    queue<int> q;
    for(int i=1;i<=n;i++){
        int t; cin >> t;
        if(t!=-1){
            arr[t].push_back(i);
        } else {
            q.push(i);
        }
    }
    while(!q.empty()){
        int node = q.front();
        q.pop();
        res = max(res, dfs(node, arr));
    }
    cout << res << endl;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    ll t;
    cin >> t;
    while (t--) solve();
}

