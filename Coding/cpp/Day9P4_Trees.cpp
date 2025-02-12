#include<iostream>
#include "TreeNode.cpp"
#include<queue>
#include<vector>
using namespace std;

TreeNode* buildTree(int vals[], int n){
    if(n == 0 || vals[0] == -1) return nullptr;
    TreeNode* root = new TreeNode(vals[0]);
    queue<TreeNode*> q;
    q.push(root);
    
    int i = 1;
    while(i<n){
        TreeNode* curr = q.front();
        q.pop();
        if(i<n && vals[i]!=-1){
            curr->left = new TreeNode(vals[i]);
            q.push(curr->left);
        }
        i++;
        if(i<n && vals[i]!=-1){
            curr->right = new TreeNode(vals[i]);
            q.push(curr->right);
        }
        i++;
    }
    return root;
}

void leftBound(TreeNode* root, vector<int>& res){
    TreeNode* curr = root->left;
    while(curr){
        if(curr->left || curr->right){
            res.push_back(curr->val);
        }
        curr = (curr->left) ? curr->left : curr->right;
    }
}

void leaves(TreeNode* root, vector<int>& res){
    if(!root) return;
    if(!root->left && !root->right){
        res.push_back(root->val);
    }
    leaves(root->left, res);
    leaves(root->right, res);
}

void rightBound(TreeNode* root, vector<int>& res){
    TreeNode* curr = root->right;
    vector<int> temp;
    while(curr){
        if(curr->left || curr->right){
            temp.push_back(curr->val);
        }
        curr = (curr->right) ? curr->right : curr->left;
    }
    for(int i = temp.size() - 1; i >= 0; i--){
        res.push_back(temp[i]);
    }
}

vector<int> boundaryTraversal(TreeNode* root){
    vector<int> res;
    if(!root) return res;
    res.push_back(root->val);
    leftBound(root, res);
    leaves(root, res);
    rightBound(root, res);
    return res;
}

int main() {
    int vals[] = {11, 2, 13, 4, 25, 6, -1, -1, -1, 7, 18, 9, 10};
    int n = sizeof(vals) / sizeof(vals[0]);
    TreeNode* root = buildTree(vals, n);
    vector<int> res = boundaryTraversal(root);
    for(int i=0; i<res.size(); i++){
        cout << res[i] << " ";
    }
    cout << endl;
}