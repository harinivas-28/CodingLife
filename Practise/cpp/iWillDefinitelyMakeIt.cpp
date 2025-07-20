/*
Can You Reach the Tallest Tower?
You are given n towers, each with a specific height h_i. You start at tower k at time 0, and the water level begins at 1.

Every second, the water level rises by 1 unit. If the water level ever strictly exceeds the height of your current tower, you drown.

You possess a magical ability: at any moment x, you can start teleporting from your current tower i to another tower j. This teleportation takes ∣h_i−h_j∣ seconds. During this travel time, you remain on tower i. You arrive at tower j at moment x+∣h_i−h_j∣, and you can initiate another teleportation immediately upon arrival.

Example: If n=k=4 and h=[4,4,4,2], teleporting from tower 4 to tower 1 at moment 0 means you stay on tower 4 until moment ∣h_4−h_1∣=∣2−4∣=2. At moment 2, you arrive at tower 1. Note that if tower 1's height were 5, you'd drown at moment 2 if you started at tower 4 (height 2).

Your ultimate goal is to reach any tower with the maximum height before the water submerges you.

Can you achieve this?

Input
The input consists of t test cases (1
let
le10 
4
 ).

Each test case begins with two integers:

n: The number of towers (1
lek
len
le10 
5
 ).

k: The index of your starting tower.

The second line contains n integers:

h_1,h_2,
ldots,h_n: The heights of the towers (1
leh_i
le10 
9
 ).

The sum of n across all test cases will not exceed 10 
5
 .

Output
For each test case, print "YES" if it's possible to reach a maximum height tower, and "NO" otherwise. (Case-insensitive)

Example
Input:
5
5 3
3 2 1 4 5
3 1
1 3 4
4 4
4 4 4 2
6 2
2 3 6 9 1 2
4 2
1 2 5 6

Output:
YES
NO
YES
YES
NO
*/
#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, pos;
    cin >> n >> pos;
    vector<int> v(n);
    for(int i=0;i<n;i++){
        cin >> v[i];
    }
    int waterLevel = 1;
    int curr = v[pos-1];
    sort(v.begin(), v.end());
    for(int i=0;i<n;i++){
        int diff = v[i]-curr;
        if(waterLevel+diff-1>curr){
            cout << "NO" << endl;
            return;
        }
        curr = v[i];
        waterLevel += diff;
    }
    cout << "YES" << endl;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while(t--){
        solve();
    }
}