#ifndef DSU_H
#define DSU_H
#include<vector>
using namespace std;

class DSU {
    private:
        vector<int> parent, rank;
    public:
        DSU(int n){
            parent = vector<int>(n);
            rank = vector<int>(n);
            for(int i=0;i<n;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        int _find(int x){
            if(parent[x]!=x)
                parent[x] = _find(parent[x]);
            return parent[x];
        }
        void _union(int x, int y){
            int rx = _find(x), ry = _find(y);
            if(rx!=ry){
                if(rank[rx]>rank[ry]){
                    parent[ry] = rx;
                    rank[rx] += rank[ry];
                } else {
                    parent[rx] = ry;
                    rank[ry] += rank[rx];
                }
            }
        }
};
#endif 