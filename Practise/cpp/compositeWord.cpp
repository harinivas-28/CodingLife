#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

bool isCompositeWord(const string &word, const unordered_set<string> &dict) {
    int n = word.size();
    for (int i = 1; i < n; i++) {
        string prefix = word.substr(0, i);
        string suffix = word.substr(i);
        if (dict.count(prefix) && dict.count(suffix)) {
            return true;
        }
    }
    return false;
}

int main() {
    unordered_set<string> dictionary = {"hello", "world", "apple", "pen", "cat", "dog", "sand", "witch"};
    
    vector<string> testCases = {"helloworld", "applepen", "catdog", "sandwitch", "dogcat", "helloapple"};
    
    for (const string &word : testCases) {
        cout << "Is '" << word << "' a composite word? " 
             << (isCompositeWord(word, dictionary) ? "Yes" : "No") << endl;
    }
    
    return 0;
}
