//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// gfg
// lc-741
// } Driver Code Ends

class Solution {
  public:
    int solve(int n, int m, vector<vector<int>>& grid) {
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(m , 0)));
        // Initialize last row
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2]; 
            }
        }
        
        // Process rest of the rows
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi = -1e8;
                    for(int dj1=-1;dj1<=+1;dj1++){
                        for(int dj2=-1;dj2<=+1;dj2++){
                            int val = 0;
                            if(j1==j2) 
                                val = grid[i][j1];
                            else 
                                val = grid[i][j1] + grid[i][j2];
                                
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            
                            if(newJ1>=0 && newJ2>=0 && newJ1<m && newJ2<m)
                                val += dp[i+1][newJ1][newJ2];
                            else 
                                val = -1e8;
                                
                            maxi = max(maxi, val);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
};

/*
class Solution {
    public:
        int f(int i, int j1, int j2, int n, int m, vector<vector<int>>& grid, vector<vector<vector<int>>>& dp){
            if(j1<0 || j2<0 || j1>=m || j2>=m) return -1e8;
            if(i==n-1){
                if(j1==j2) return grid[i][j1];
                return grid[i][j1] + grid[i][j2];
            }
            if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
            int maxi = -1e8;
            for(int dj1=-1;dj1<=+1;dj1++){
                for(int dj2=-1;dj2<=+1;dj2++){
                    int val = 0;
                    if(j1==j2) val = grid[i][j1];
                    else val = grid[i][j1] + grid[i][j2];
                    val += f(i+1, j1+dj1, j2+dj2, n, m, grid, dp);
                    maxi = max(maxi, val);
                }
            }
            return dp[i][j1][j2] = maxi;
        }
        int solve(int n, int m, vector<vector<int>>& grid) {
            // code here
            vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(m, -1)));
            return f(0, 0, m-1, n, m, grid, dp);
        }
    };
*/

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