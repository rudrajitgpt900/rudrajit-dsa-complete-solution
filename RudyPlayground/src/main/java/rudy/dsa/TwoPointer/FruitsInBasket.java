package rudy.dsa.TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitsInBasket {

    public static int totalFruits(int N, int[] fruits) {

        int left =0;
        int right = 0;
        int len =0;
        int maxlen =0;
        int k = 2;
        List<Integer>list= new ArrayList<>();
        Map<Integer,Integer>map= new HashMap<>();
        while (right<N){

            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);

            if(map.size()<=k){
                maxlen= Math.max(maxlen, right-left+1);
            }
            while(map.size()>k){
                if(map.containsKey(fruits[left])){
                    map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                    if(map.get(fruits[left])==0)
                        map.remove(fruits[left]);
                    left++;
                }
            }

            right++;
        }
        for(int i = left; i<right;i++){
            list.add(i);
        }
        System.out.println("Sub-array index are: "+ list);
        return maxlen;

    }

    public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        int left = 0;
        int right =0;
        int ans =0;
        Map<Character,Integer>map= new HashMap<>();
        while(right<n){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()<=k){
                ans = Math.max(ans , right - left +1);
            }
            while(map.size()>k){
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
                    if(map.get(s.charAt(left)) == 0)
                        map.remove(s.charAt(left));
                    left++;
                }
            }

            right++;
        }

        return map.size()<k?-1:ans;
    }
    public static void main(String[] args) {
        int []a={0, 1, 2, 2, 2, 2};

        System.out.println(totalFruits(a.length,a));
    }
}
