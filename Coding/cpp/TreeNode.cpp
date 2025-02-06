#ifndef TREENODE_H //
#define TREENODE_H //

#include<iostream>
using namespace std;

class TreeNode {
    public:
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val): val(val), left(nullptr), right(nullptr) {}
    TreeNode(int val, TreeNode* left, TreeNode* right): left(left), right(right) {}
};

#endif // TREENODE_H