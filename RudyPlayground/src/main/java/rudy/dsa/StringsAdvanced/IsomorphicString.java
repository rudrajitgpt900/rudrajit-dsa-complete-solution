package rudy.dsa.StringsAdvanced;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m)return false;

        Map<Character,Character> map = new HashMap<>();
        int i =0;
        int j=0;
        while(i<n && j<m){
            var curr = s.charAt(i);
            var mappedChar = t.charAt(j);
            if(map.containsKey(curr) && map.get(curr)!=mappedChar)return false;
            else if(map.containsKey(curr) && map.get(curr)==mappedChar){
                i++;
                j++;
            }
            else {
                map.put(curr , mappedChar);
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicString isomorphicString = new IsomorphicString();
        String s = "egg";
        String t = "add";
        boolean result = isomorphicString.isIsomorphic(s, t);
        System.out.println("Are the strings isomorphic? " + result);
    }
}
