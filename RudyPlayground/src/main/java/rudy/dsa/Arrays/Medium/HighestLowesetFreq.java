package rudy.dsa.Arrays.Medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HighestLowesetFreq {

    public static int[] getFrequencies(int []v) {
        // Write Your Code Here
        Map<Integer , Integer> map = new LinkedHashMap<>();

        for (int cur : v) {
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int []ans= new int[2];
        int minFreq= Integer.MAX_VALUE;
        int minElement =Integer.MAX_VALUE;
        int maxFreq =Integer.MIN_VALUE;
        int maxElement=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();
            if(freq >= maxFreq){
                maxFreq= freq;
                maxElement = Math.min(maxElement ,key);
            }
            if(freq<= minFreq && freq!=maxFreq){
                minFreq= freq;
                minElement = Math.min(minElement,key);
            }
        }
        if(minElement == Integer.MAX_VALUE) minElement = maxElement;

        ans[0]=maxElement;
        ans[1]= minElement;

        return ans;
    }

    public static void main(String[] args) {

        int[]a = new int [] {7,9, 9 ,15 ,5};
        System.out.println(Arrays.toString(getFrequencies(a)));
    }
}
