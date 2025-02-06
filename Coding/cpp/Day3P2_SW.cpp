#include<iostream>
#include<string>
using namespace std;

bool isPrime(int num){
    if(num<=1) return false;
    for(int i=2;i*i<=num;i++){
        if(num%i==0){
            return false;
        }
    }
    return true;
}

int slideWind(string s, int k){
    int res = 0;
    int sNum = stoi(s);
    int r = 0;
    string sb;
    while(r<s.size()){
        sb += s[r];
        if(r>=k-1){
            int num = stoi(sb);
            res += (sNum%num==0 && isPrime(num)) ? 1 : 0;
            sb.erase(0, 1);
        }
        r++;
    }
    return res;
}

int main() {
    string s; cin >> s;
    int k; cin >> k;
    int sNum = stoi(s);
    // APPROACH 1
    int res = 0;
    for(int i=0;i<s.size()-k+1;i++){
        int num = stoi(s.substr(i, k));
        res += (sNum%num==0 && isPrime(num)) ? 1 : 0;
    }
    cout << "Method 1: " << res << endl;
    // APPROACH 2
    int res2 = slideWind(s, k);
    cout << "Method 2: " << res2;
}