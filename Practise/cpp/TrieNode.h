#ifndef TRIENODE_H
#define TRIENODE_H

using namespace std;
class TrieNode {
    public:
        TrieNode* children[26];
        bool isEnd;
        TrieNode(){
            for(int i=0;i<26;i++){
                children[i] = nullptr;
            }
            isEnd = false;
        }
};

#endif