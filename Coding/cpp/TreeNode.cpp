#ifndef TREENODE_H // Todo: Learn how this class is implemented
#define TREENODE_H // Todo: How it gets imported?

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