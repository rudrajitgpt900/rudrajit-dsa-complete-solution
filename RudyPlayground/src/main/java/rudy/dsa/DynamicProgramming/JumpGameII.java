package rudy.dsa.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int[]dp = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[n-1]= 0;
        for(int i = n-2; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<=Math.min(i+nums[i],n-1); j++){
                min = Math.min(min, dp[j]);
            }
            if(min<dp[i])
                dp[i]=1+min;

        }


        return dp[0];
    }

    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
       // System.out.println(obj.jump(new int[]{2,3,1,1,4}));

        Set<Integer>set= new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(4);

        Set<Integer>set1= new HashSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(4);

        System.out.println(set1.equals(set));
    }
}
