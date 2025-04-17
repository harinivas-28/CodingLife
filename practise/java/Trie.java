package practise.java;

public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }
    public boolean find(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
    public void printTrie() {
        printTrieHelper(root, new StringBuilder());
    }
    
    private void printTrieHelper(TrieNode node, StringBuilder currentWord) {
        if (node.isEnd) {
            System.out.println(currentWord.toString());
        }
    
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                currentWord.append((char)(i + 'a'));
                printTrieHelper(node.children[i], currentWord);
                currentWord.deleteCharAt(currentWord.length() - 1); // backtrack
            }
        }
    }    
}
