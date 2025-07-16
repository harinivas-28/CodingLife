#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include "TreeNode.cpp"

using namespace std;
static int preInd;

TreeNode* buildTreeHelper(vector<int>& in, vector<int>& pre, int start, int end){
    if(start>end) return nullptr;
    int rootVal = pre[preInd++];
    TreeNode* root = new TreeNode(rootVal);
    auto it = find(in.begin(), in.end(), rootVal); // Todo : Learn about auto, find and inner parameters
    int idx = distance(in.begin(), it); // Todo : learn about distance and inner parameters
    // F*cking Procastination (Sometime you have to *-*)
    root->left = buildTreeHelper(in, pre, start, idx-1);
    root->right = buildTreeHelper(in, pre, idx+1, end);
    return root;
}

TreeNode* buildTree(vector<int>& in, vector<int>& pre){
    preInd = 0;
    return buildTreeHelper(in, pre, 0, in.size()-1);
}

vector<int> levelOrder(TreeNode* root, int a, int b){
    vector<int> res;
    if(!root) return res;
    queue<TreeNode*> q;
    int level = 1;
    q.push(root);
    while(!q.empty()){
        int size = q.size();
        vector<int> zag;
        for(int i=0;i<size;i++){
            TreeNode* temp = q.front();
            q.pop();
            if(!temp){
                if(level>=a && level<=b) zag.push_back(temp->val);
                if(!temp->left) q.push(temp->left);
                if(!temp->right) q.push(temp->right);
            }
        }
        if(level>=a && level<=b){
            if(level%2==0){
                reverse(zag.begin(), zag.end()); // Todo : Learn this line later
            }
            res.insert(res.end(), zag.begin(), zag.end()); // Todo: Learn this also
        }
        level++;
    }
    return res;
}

int main() {
    int n;
    cin >> n;
    vector<int> in(n), pre(n);
    for (int i = 0; i < n; i++) cin >> in[i];
    for (int i = 0; i < n; i++) cin >> pre[i];
    int a, b;
    cin >> a >> b;
    TreeNode* root = buildTree(in, pre);
    vector<int> res = levelOrder(root, a, b); // Todo: Code is not working properly, will do 2morrow!
    cout << res.size();
    for (int num : res) cout << num << " ";
    cout << endl; 
    return 0;
}