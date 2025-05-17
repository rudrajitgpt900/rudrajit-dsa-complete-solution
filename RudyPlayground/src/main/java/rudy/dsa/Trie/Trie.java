package rudy.dsa.Trie;


public class Trie {

    public final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for(char ch: word.toCharArray()){
            if(!current.links.containsKey(ch)){
                current.links.put(ch, new TrieNode());
            }
            current = current.links.get(ch);
        }
        current.endWith=true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;
        for(char ch: word.toCharArray()){
            if(!current.links.containsKey(ch)){
                return false;
            }
            current = current.links.get(ch);
        }
        return current.endWith;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for(char ch: prefix.toCharArray()){
            if(!current.links.containsKey(ch)){
                return false;
            }
            current = current.links.get(ch);
        }
        return true;
    }
}
