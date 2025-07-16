#include<iostream>
#include<string>
#include<vector>
#include<unordered_map>
#include<cmath>
#include<queue>
using namespace std;

int main() {
    int n, k, x, f;
    cin >> n >> k >> x >> f;
    vector<int> arr(n);
    unordered_map<int, int> map;
    vector<int> res;
    for(int i=0;i<n;i++) cin >> arr[i];

    int l=0, r=0;
    while(r<n){
        map[arr[r]]++;
        priority_queue<pair<int, int>> pq; 
        /*
         It is used to store a pair of values, which can be of different types. The pair class provides a way to group two values together.
        */

        if(r >= k-1) {
            for(auto& entry: map){ // auto& entry automatically deduces the type of entry to be std::pair<const int, int>&.
                int key = entry.first;
                int val = entry.second;
                int tot = val * pow(key, f);
                pq.push({key, tot});
            }
            int temp = x;
            int sum = 0;
            while (temp>0 && !pq.empty()){
                pair<int, int> p = pq.top();
                pq.pop();
                int freq = map[p.first];
                sum += p.first * freq;
                temp--;
            }
            res.push_back(sum);
            if(--map[arr[l]]==0) map.erase(map[arr[l]]);
            l++;
        }
        r++;
    }
    /*
    Using int is generally fine for small to moderately sized vectors.
    For very large vectors or to ensure type consistency, size_t is preferred.
    */
    cout << "[";
    for(size_t i=0;i<res.size();i++){ 
        cout << res[i];
        if(i!=res.size()-1) cout << ", ";
    }
    cout << "]" << endl;
}