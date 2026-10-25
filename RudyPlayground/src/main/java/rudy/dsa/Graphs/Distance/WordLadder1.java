package rudy.dsa.Graphs.Distance;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class NodeInfo{
    String word;
    int level;
    List<String>sequence;

    NodeInfo( String word, int level, List<String>sequence){
        this.word= word;
        this.level= level;
        this.sequence = sequence;
        this.sequence.add(word);
    }
}

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<NodeInfo> queue= new LinkedList<>();
        Set<String>wordSet = new HashSet<>(wordList);
        Set<String>dlq = new HashSet<>(wordList);
        List<List<String>> sequences = new ArrayList<>();
        queue.add(new NodeInfo(beginWord,1 , new ArrayList<>()));
        wordSet.remove(beginWord);
        int ans = 0;
        while (!queue.isEmpty()){
            NodeInfo front = queue.poll();
            String word = front.word;
            int level = front.level;
            var sequence = front.sequence;
            if(word.equals(endWord)) {
                sequences.add(sequence);
                ///wordSet.addAll(dlq);
                ans= level;
            }
            //hit

            for(int i=0;i<word.length();i++){

                for(char ch = 'a'; ch<='z' ; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String transformedWord = new String(charArray);
                    if(wordSet.contains(transformedWord)){
                        wordSet.remove(transformedWord);
                   //     dlq.add(transformedWord);
                        queue.add(new NodeInfo(transformedWord, level+1,sequence));
                        break;
                    }

                }

            }


        }
        System.out.println(sequences);
        return ans;

    }

    public static void main(String[] args) {
        WordLadder1 obj = new WordLadder1();
        int ladderLength = obj.ladderLength("der", "dfs", Arrays.asList("des", "der", "dfr", "dgt", "dfs"));
        System.out.println(ladderLength);
        char ch = 'A';
        int pow = (int)Math.pow(26,2);
        ch++;
        System.out.println(pow);
    }
}
