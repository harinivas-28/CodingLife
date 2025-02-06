#include<iostream>
#include<vector>
#include "TreeNode.cpp"
using namespace std;

vector<int> res;

TreeNode* buildTree(int levelOrder[], int n, int idx){
    if(idx >= n) return nullptr;
    TreeNode* root = new TreeNode(levelOrder[idx]);
    root->left = buildTree(levelOrder, n, 2*idx+1);
    root->right = buildTree(levelOrder, n, 2*idx+2);
    return root;
}

void inorder(TreeNode* root){
    if(root==nullptr) return;
    inorder(root->left);
    res.push_back(root->val);
    inorder(root->right);
}

int main() {
    int n; cin >> n;
    int levelOrder[n];
    for(int i=0;i<n;i++) cin >> levelOrder[i];

    int idx = 0;
    TreeNode* root = buildTree(levelOrder, n, idx);
    inorder(root);
    for(int val : res) cout << val << " ";
    return 0;
}