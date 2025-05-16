#include<bits/stdc++.h>
using namespace std;

int main(){
    int n, p;
    cin >> n >> p;
    vector<int> cmp(n);
    for(int i=0;i<n;i++) cin >> cmp[i];
    vector<pair<int, int>> v;
    vector<int> res(p);
    for(int i=0;i<p;i++){
        int x, y;
        cin >> x >> y;
        v.push_back({x, y});
    }
    for(int k=0;k<p;k++){
        pair<int, int> p = v[k];
        int idx = p.first;
        int tar = p.second;
        int dist = 0;
        bool f = false;
        int i = idx, j = idx;
        while(i>=0 || j<n){
            if(i>=0 &&cmp[i]==tar){
                f = true;
                break;
            }
            if(j<n && cmp[j]==tar){
                f = true;
                break;
            }
            i--;
            j++;
            dist++;
        }
        res[k] = f?dist :-1;
    }
    for(auto& x: res){
        cout << x << " ";
    }
    cout << endl;
}