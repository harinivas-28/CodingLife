package Practise.java;

public class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
        for(int i=0;i<26;i++){
            children[i] = null;
        }
        isEnd = false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrieNode{isEnd=").append(isEnd).append(", children=[");

        for (int i = 0; i < 26; i++) {
            if (children[i] != null) {
                sb.append((char) (i + 'a')).append(", ");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 2) == ',') {
            sb.setLength(sb.length() - 2); // remove last comma and space
        }
        sb.append("]}");
        return sb.toString();
    }
}
