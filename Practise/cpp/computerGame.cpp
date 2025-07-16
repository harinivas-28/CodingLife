/*
A. Computer Game
time limit per test2 seconds
memory limit per test256 megabytes
Monocarp is playing a computer game. Now he wants to complete the first level of this game.

A level is a rectangular grid of 2
 rows and n
 columns. Monocarp controls a character, which starts in cell (1,1)
 — at the intersection of the 1
-st row and the 1
-st column.

Monocarp's character can move from one cell to another in one step if the cells are adjacent by side and/or corner. Formally, it is possible to move from cell (x1,y1)
 to cell (x2,y2)
 in one step if |x1−x2|≤1
 and |y1−y2|≤1. Obviously, it is prohibited to go outside the grid.

There are traps in some cells. If Monocarp's character finds himself in such a cell, he dies, and the game ends.

To complete a level, Monocarp's character should reach cell (2,n)
 — at the intersection of row 2
 and column n.

Help Monocarp determine if it is possible to complete the level.

Input
The first line contains a single integer t
 (1≤t≤100) — the number of test cases. Then the test cases follow. Each test case consists of three lines.

The first line contains a single integer n
 (3≤n≤100) — the number of columns.

The next two lines describe the level. The i
-th of these lines describes the i
-th line of the level — the line consists of the characters '0' and '1'. The character '0' corresponds to a safe cell, the character '1' corresponds to a trap cell.

Additional constraint on the input: cells (1,1)
 and (2,n)
 are safe.

Output
For each test case, output YES if it is possible to complete the level, and NO otherwise.

Example
4
3
000
000
4
0011
1100
4
0111
1110
6
010101
101010
Output
YES
YES
NO
YES
Note
Consider the example from the statement.

In the first test case, one of the possible paths is (1,1)→(2,2)→(2,3).

In the second test case, one of the possible paths is (1,1)→(1,2)→(2,3)→(2,4).

In the fourth test case, one of the possible paths is (1,1)→(2,2)→(1,3)→(2,4)→(1,5)→(2,6).
*/
#include<bits/stdc++.h>
using namespace std;

/* DFS
const int dr[] = {-1,-1,-1, 0, 0, 1, 1, 1};
const int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
vector<vector<bool>> vis;
bool dfs(int i, int j, vector<vector<int>> &arr, int n){
    if(i<0 || j<0 || i>=2 || j>=n || arr[i][j]==1) return false;
    if(vis[i][j]) return false;
    if(i==1 && j==n-1){
        return true;
    }
    vis[i][j] = true;
    bool found = false;
    for(int d=0;d<8;++d){
        int newI = i + dr[d];
        int newJ = j + dc[d];
        if(dfs(newI, newJ, arr, n)){
            found = true;
            break;
        }
    }
    vis[i][j] = false;
    return found;
}
*/

/* BFS
void bfs(int n, vector<vector<int>> &arr){
    queue<pair<int, int>> q;
    vector<vector<bool>> vis(2, vector<bool>(n, false));
    q.push({0, 0});
    vis[0][0] = true;
    while(!q.empty()){
        auto [x, y] = q.front();q.pop();
        for(int i=0;i<8;++i){
            int nx = x + dr[i];
            int ny = y + dc[i];
            if(nx>=0 && nx<2 && ny>=0 && ny<n && !vis[nx][ny]
                && arr[nx][ny]==0){
                    vis[nx][ny] = true;
                    q.push({nx, ny});
            }
        }
    }
    string res = vis[1][n-1] ? "YES": "NO";
    cout << res << endl;
}
*/

void solve(){
    int n;
    cin >> n;
    // SIMPLE APPROACH DOWN
    // vector<vector<int>> arr(2, vector<int>(n));
    // string line;
    // for(int i=0;i<2;i++){
    //     cin >> line;
    //     for(int j=0;j<n;j++){
    //         arr[i][j] = line[j]-'0';
    //     }
    // }

    // vis.assign(2, vector<bool>(n, false));
    // string res = dfs(0, 0, arr, n) ? "YES" : "NO";
    // cout << res << endl;
    
    // bfs(n, arr);
    
    // Simple Approach
    string r1, r2;
    cin >> r1 >> r2;
    for(int i=0;i<n;i++){
        if(r1[i]=='1' && r2[i]=='1'){
            // BLOCKED WALL
            cout << "NO" << endl;
            return;
        }
    }
    cout << "YES" << endl;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while(t--){
        solve();
    }
}