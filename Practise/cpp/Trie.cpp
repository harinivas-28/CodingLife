#include "Trie.h"
using namespace std;

Trie::Trie(){
    root = new TrieNode();
}

void Trie::insert(const string& word){
    TrieNode* node = root;
    for(char c: word){
        if(node->children[c-'a']==nullptr)
            node->children[c-'a'] = new TrieNode();
        node = node->children[c-'a'];
    }
    node->isEnd = true;
}

bool Trie::find(const string& word){
    TrieNode* node = root;
    for(char c: word){
        if(node->children[c-'a']==nullptr)
            return false;
        node = node->children[c-'a'];
    }
    return node->isEnd;
}

bool Trie::startsWith(const string& prefix){
    TrieNode* node = root;
    for(char c: prefix){
        if(node->children[c-'a']==nullptr)
            return false;
        node = node->children[c-'a'];
    }
    return true;
}

void Trie::clear(TrieNode* node){
    if(!node) return;
    for(int i=0;i<26;i++){
        if(node->children[i]){
            clear(node->children[i]);
        }
    }
    delete node;
}

Trie::~Trie() {
    clear(root);
}