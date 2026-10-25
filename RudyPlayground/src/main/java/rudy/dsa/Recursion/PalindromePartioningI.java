package rudy.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioningI {
    public List<List<String>> partition(String s) {

        List<List<String>>allPartions = new ArrayList<>();
        List<String>subPartition = new ArrayList<>();
        int startIndex = 0;
        int len = s.length();
        getPartions(s,startIndex,len,subPartition,allPartions);

        return allPartions;

    }

    private void getPartions(String s, int startIndex, int len,List<String> subPartition, List<List<String>> allPartions) {

        if(startIndex == len){
            allPartions.add(new ArrayList<>(subPartition));
            return;
        }

        for(int range =startIndex ; range<len;range++){
            if(isPalindrome(s,startIndex,range)){
                subPartition.add(s.substring(startIndex, range+1));
                getPartions(s,startIndex+1,len,subPartition,allPartions);
                subPartition.remove(subPartition.size()-1);

            }

        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;

        }
        return true;
    }
}
