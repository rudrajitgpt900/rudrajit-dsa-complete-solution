package rudy.dsa.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

/*

* Here givven input will contain all elemenet from zero to 10^9
all non negative with zeroes basically

**/
public class LongestSubarrayWithSumK {


    public static int longestSubarrayWithSumK(int []a, long k){

        int n = a.length;
        long preFixSum = 0;
        Map<Long , Integer> preFixSumMap = new HashMap<Long , Integer>();
        int maxLength =Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            preFixSum += a[i];
            if(preFixSum == k){
                maxLength = Math.max(maxLength,i+1);
            }

            long remaining = preFixSum - k;
            if(preFixSumMap.containsKey(remaining)){
                int length = i - preFixSumMap.get(remaining);
                maxLength = Math.max(maxLength,length);
            }

            if(!preFixSumMap.containsKey(preFixSum))
                preFixSumMap.put(preFixSum,i);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        int a[]= {2,0,0,3};
        System.out.println(longestSubarrayWithSumK(a,3));
    }
}
