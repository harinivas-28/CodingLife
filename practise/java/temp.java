package practise.java;
public class temp {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("bad");
        System.out.println("Words in Trie:");
        trie.printTrie();
    }
}
