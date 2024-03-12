package rudy.dsa.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //HashMap
        /**
         map : k->Int v->Int

         */
        int[]result = new int[2];
        Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
        for(int i =0 ; i< nums.length; i++){
            int compliment = target - nums[i]; //7 ,2
            if(!map.containsKey(compliment)){
                map.put(nums[i] ,i); // target map=>{(2,i)}
            }
            else{
                result[0]=map.get(compliment);
                result[1]= i;
            }
        }

        return result;
    }
}
