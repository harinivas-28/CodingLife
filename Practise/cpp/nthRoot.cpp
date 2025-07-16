#include<bits/stdc++.h>
using namespace std;

void findNthRoot(int x, int n){
    double low, high;
    if(x>=0 && x<=1){
        low = x;
        high = 1;
    } else {
        low = 1;
        high = x;
    }
    double eps = 1e-09;
    double guess = (low+high)/2;
    while(abs(pow(guess, n)-x) >= eps){
        if(pow(guess, n)>x){
            high = guess;
        } else {
            low = guess;
        }
        guess = (low+high)/2;
    }
    cout << fixed << setprecision(16) << guess;
}

int main(){
    int x, n;
    cin >> x >> n;
    findNthRoot(x, n);
}