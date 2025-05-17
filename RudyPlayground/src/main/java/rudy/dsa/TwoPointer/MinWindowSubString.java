package rudy.dsa.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left =0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int cnt = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<m;i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) ,0) +1);
        }

        while(right < n){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar)){
                if(map.get(currentChar) >0)
                    cnt++;
            }
            map.put(currentChar , map.getOrDefault(currentChar ,0) -1 );

            while(cnt == m){
                if(right - left +1 < minLen){
                    minLen = right-left+1;
                    startIndex = left;

                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar , map.get(leftChar) +1);
                    if(map.get(leftChar) > 0){
                        cnt --;
                    }
                }
                left++;

            }
            right++;

        }

        return startIndex == -1?"": s.substring(startIndex, startIndex+minLen);

    }
}
