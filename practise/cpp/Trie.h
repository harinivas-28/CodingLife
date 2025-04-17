#ifndef TRIE_H
#define TRIE_H
#include "TrieNode.h"
#include<string>
using namespace std;

class Trie {
    TrieNode* root;
    public:
        Trie();
        ~Trie();
        void insert(const string& word);
        bool find(const string& word);
        bool startsWith(const string& prefix);
    private:
        void clear(TrieNode* node);
};

#endif