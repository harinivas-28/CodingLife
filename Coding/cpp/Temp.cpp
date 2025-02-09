#include<iostream>
// #include<vector>
using namespace std;


// 71A
// string tooLong(string s){
//     int size = s.length();
//     if(size<=10) return s;
//     return s[0] + to_string(size-2) + s[size-1];
// }

// int main(){
//     int t; cin >> t;
//     // vector<string> res;
//     while(t--){
//         string s;
//         cin >> s;
//         // res.push_back(tooLong(s));
//         cout << tooLong(s) << endl;
//     }
//     // for(string s: res){
//     //     cout << s << endl;
//     // }
// }

string perm(string& s, int n){
    if(n==1) return s;
    int i = 0;
    while(i<n && s[i]==s[n]){
        n--;
    }
    s[i] = s[n];
    return s;
}

int main() {
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        string s; cin >> s;
        cout << perm(s, n-1) << endl;
    }
}