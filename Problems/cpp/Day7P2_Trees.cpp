#include<iostream>
#include<vector>
#include "TreeNode.cpp"
#include<queue>
#include<sstream>
#include<algorithm>

using namespace std;

static int preInd = 0;
static vector<int> res; 

TreeNode* buildTreeHelper(vector<int>& pre, vector<int>& post, int start, int end){
    if(preInd>=pre.size() || start>end) return nullptr;
    int rootVal = pre[preInd++];
    TreeNode* root = new TreeNode(rootVal);
    if(start==end) return root;
    int leftChild = pre[preInd];
    int idx = find(post.begin(), post.end(), leftChild) - post.begin();
    root->left = buildTreeHelper(pre, post, start, idx);
    root->right = buildTreeHelper(pre, post, idx+1, end-1);
    return root;
}

TreeNode* buildTree(vector<int>& pre, vector<int>& post){
    return buildTreeHelper(pre, post, 0, post.size()-1);
}

void inorder(TreeNode* root){
    if(!root){ return; }
    inorder(root->left);
    res.push_back(root->val);
    inorder(root->right);
}

vector<vector<int>> levelOrder(TreeNode* root){
    vector<vector<int>> res;
    if(!root) return res;
    queue<TreeNode*> q;
    q.push(root);
    while(!q.empty()){
        int size = q.size();
        vector<int> temp;
        for(int i=0;i<size;i++){
            TreeNode* tempNode = q.front();
            q.pop();
            if(tempNode){
                temp.push_back(tempNode->val);
                q.push(tempNode->left);
                q.push(tempNode->right);
            }
        }
        res.push_back(temp);
    }
    return res;
}

int main() {
    string preLine, postLine;
    getline(cin, preLine);
    getline(cin, postLine);

    vector<int> pre, post;
    stringstream preSS(preLine), postSS(postLine);
    
    int num;
    while(preSS >> num) pre.push_back(num);
    while(postSS >> num) post.push_back(num);

    TreeNode* root = buildTree(pre, post);
    res.clear();
    inorder(root);
    cout << "In-Order: [";
    for(int i: res) cout << i << ", ";
    cout << "]" << endl;
    vector<vector<int>> lvl = levelOrder(root);

    cout << "Level Order: [";
    for (size_t i = 0; i < lvl.size(); i++) {
        cout << "[";
        for (size_t j = 0; j < lvl[i].size(); j++) {
            cout << lvl[i][j] << (j < lvl[i].size() - 1 ? ", " : "");
        }
        cout << "]" << (i < lvl.size() - 1 ? ", " : "");
    }
    cout << "]" << endl;
    return 0;
}