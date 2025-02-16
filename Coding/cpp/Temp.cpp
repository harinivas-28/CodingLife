#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
int getScore(int x, int nums[], int n){
    int i = n-1;
    if(nums[i]>x) return 0;
    while(i>=0 && nums[i]<=x){
        x = x^nums[i];
        i--;
    }
    return x;
}

vector<int> simulate(int nums[], int queries[], int n, int q){
    vector<int> res;
    for(int x=0;x<q;x++){
        res.push_back(getScore(queries[x], nums, n));
    }
    return res;
}

int main() {
    int t; cin >> t;
    while(t--){
        int n, q;
        cin >> n >> q;
        int nums[n];
        for(int i=0;i<n;i++) cin >> nums[i];
        int queries[q];
        for(int i=0;i<q;i++) cin >> queries[i];
        vector<int> res = simulate(nums, queries, n, q);
        for(int x:res){
            cout << x << " ";
        }
        cout << endl;
    }
    return 0;
}