#include<bits/stdc++.h>
using namespace std;

/*
In the world of secret codes and cryptography, you are entrusted with deciphering a hidden message. 
You have two encoded keys, key1 and key2, both of equal length. Each character 
in key1 is paired with the corresponding character in key2. 

This relationship follows the standard rules of an equivalence cipher:
• Self-Mapping: Every character inherently maps to itself.  
• Mutual Mapping: If a character from key1 maps to one in key2, then that 
  character in key2 maps back to the one in key1.  
• Chain Mapping: If character A maps to B, and B maps to C, then A, B, and C 
  are all interchangeable in this cipher.

Using this mapping, you must decode a cipherText, by replacing every character 
with the smallest equivalent character from its equivalence group. 
The result should be the relatively smallest possible decoded message.


Input Format:
-------------
Three space separated strings, key1 , key2 and cipherText

Output Format:
--------------
Print a string, decoded message which is relatively smallest string of cipherText.

Example 1: 
input=
attitude progress apriori
output=
aaogoog


Explanation: The mapping pairs form groups: [a, p], [o, r, t], [g, i], [e, u], 
[d, e, s]. By substituting each character in cipherText with the smallest from 
its group, you decode the message to "aaogoog".


Constraints:  
• 1 <= key1.length, key2.length, cipherText.length <= 1000  
• key1.length == key2.length  
• key1, key2, and cipherText consist solely of lowercase English letters.

*/

class DSU {
    vector<int> parent;
    public:
        DSU(int n){
            parent = vector<int>(n);
            for(int i=0;i<n;i++) parent[i] = i;
        }
        int _find(int x){
            if(parent[x]!=x)
                parent[x] = _find(parent[x]);
            return parent[x];
        }
        void _union(int x, int y){
            int rx = _find(x), ry = _find(y);
            if(rx!=ry){
                if(rx<ry) parent[ry] = rx;
                else parent[rx] = ry;
            }
        }
};
int main(){
    string a, b, tar;
    cin >> a >> b >> tar;
    DSU* dsu = new DSU(26);
    for(int i=0;i<a.size();i++){
        int c1 = a[i]-'a', c2 = b[i]-'a';
        dsu->_union(c1, c2);
    }
    string res;
    for(char c: tar){
        char t = (char)(dsu->_find(c-'a')+'a');
        res += t;
    }
    cout << res << "\n";
}