//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int solve(int n, int m, vector<vector<int>>& grid) {
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(m, -1e8)));
        
        // Initialize first row
        for(int j1=0; j1<m; j1++) {
            for(int j2=0; j2<m; j2++) {
                if(j1 == j2)
                    dp[0][j1][j2] = grid[0][j1];
                else
                    dp[0][j1][j2] = grid[0][j1] + grid[0][j2];
            }
        }
        
        // Fill dp table
        for(int i=1; i<n; i++) {
            for(int j1=0; j1<m; j1++) {
                for(int j2=0; j2<m; j2++) {
                    int maxi = -1e8;
                    // Try all possible movements
                    for(int dj1=-1; dj1<=1; dj1++) {
                        for(int dj2=-1; dj2<=1; dj2++) {
                            int value = -1e8;
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;
                            
                            if(nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                value = dp[i-1][nj1][nj2];
                                if(j1 == j2)
                                    value += grid[i][j1];
                                else
                                    value += grid[i][j1] + grid[i][j2];
                            }
                            maxi = max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        
        // Find maximum value in last row
        int result = -1e8;
        for(int j1=0; j1<m; j1++) {
            for(int j2=0; j2<m; j2++) {
                result = max(result, dp[n-1][j1][j2]);
            }
        }
        return result;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid;
        for (int i = 0; i < n; i++) {
            vector<int> temp;
            for (int j = 0; j < m; j++) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            grid.push_back(temp);
        }

        Solution obj;
        cout << obj.solve(n, m, grid) << "\n";
    }
    return 0;
}
// } Driver Code Ends