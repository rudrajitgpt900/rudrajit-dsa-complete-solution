package rudy.dsa.Trie;


public class WordDictionary {

    private final TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = this.root;
        for(char ch : word.toCharArray()){
            if(!current.links.containsKey(ch))
                current.links.put(ch,new TrieNode());
            current = current.links.get(ch);
        }
        current.endWith = true;
    }

    //b..
    public boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch =='.'){
                for(char c ='a'; c<='z';c++){
                    var arr = word.toCharArray();
                    arr[i]= c;
                    String transformed = new String(arr);
                    if(search(transformed)) return true;
                }
            }
            if(!current.links.containsKey(ch))
                return false;
            current = current.links.get(ch);
        }

        return current.endWith;
    }
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        //System.out.println(dictionary.search("pad"));
        //System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search("..f"));
    }

}
