package rudy.dsa.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> links;
    boolean endWith;

    TrieNode(){
        this.links= new HashMap<>();
        this.endWith=false;
    }
}


