#include<bits/stdc++.h>
using namespace std;
void solve(){
    int n, k; cin >> n >> k;
    string s; cin >> s;
    string r = s;
    reverse(r.begin(), r.end());
    int i =0;
    if(k==0){
        if(s.compare(r)<0){
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
        return;
    }
    if(s.compare(r)<0){
        cout << "YES" << endl;
        return;
    }
    // Swapping Strategy
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(s[j]<s[i] && s[j]<r[i]){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                break;
            }
        }
    }
    int val = s.compare(r);
    if(val>=0){
        cout << "NO" << endl;
    } else {
        cout << "YES" << endl;
    }
}