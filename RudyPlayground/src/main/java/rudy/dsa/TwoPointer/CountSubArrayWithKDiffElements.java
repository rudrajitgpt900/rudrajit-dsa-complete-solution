package rudy.dsa.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithKDiffElements {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return fn(nums , k) - fn(nums , k-1);
    }

    public int fn(int[]arr , int k){
        int n = arr.length;
        int left =0;
        int right = 0;
        int cnt =0;
        Map<Integer,Integer>map = new HashMap<>();
        while(right<n){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                if(map.containsKey(arr[left])){
                    map.put(arr[left], map.getOrDefault(arr[left],0)-1);
                    if(map.get(arr[left])==0)
                        map.remove(arr[left]);
                    left++;
                }
            }
            cnt+=(right-left+1);
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountSubArrayWithKDiffElements obj = new CountSubArrayWithKDiffElements();
        int []arr= {1,2,1,3,4}; int k=3;
        System.out.println(obj.subarraysWithKDistinct(arr,k));
    }
}
