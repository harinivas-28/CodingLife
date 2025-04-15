//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++

class Solution {
  public:
    int inf = 1e8;
    vector<int> bellmanFord(int V, vector<vector<int>>& edges, int src) {
        // Code here
        vector<int> dist(V, inf);
        dist[src] = 0;
        for(int i=0;i<V-1;i++){
            for(auto& edge: edges){
                int u = edge[0], v = edge[1], wt = edge[2];
                if(dist[u]!=inf && dist[u]+wt<dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        for(auto& edge: edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            if(dist[u]!=inf && dist[u]+wt<dist[v]){
                return vector<int>(1, -1);
            }
        }
        return dist;
    }
};



//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<vector<int> > edges;

        for (int i = 0; i < E; ++i) {
            int u, v, w;
            cin >> u >> v >> w;

            vector<int> edge(3);
            edge[0] = u;
            edge[1] = v;
            edge[2] = w;
            edges.push_back(edge);
        }

        int src;
        cin >> src;
        cin.ignore();

        Solution obj;
        vector<int> res = obj.bellmanFord(V, edges, src);

        for (size_t i = 0; i < res.size(); i++) {
            cout << res[i] << " ";
        }
        cout << "\n";
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends