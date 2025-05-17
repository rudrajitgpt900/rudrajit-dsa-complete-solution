package rudy.dsa.TwoPointer;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int left =0;
        int right=0;
        Set<Character> set = new LinkedHashSet<>();
        while (right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max= Math.max(max ,  right - left +1);
            }
            else{
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
            right++;
        }
        return max;

    }
}
