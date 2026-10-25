package rudy.dsa.TwoPointer;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int left = 0 ;
        int right = 0;
        int maxLen = 0;
        int zero =0;
        while (right<n)
        {
            if(nums[right]==0)
                zero++;
            else {
                while (zero>k){
                    if(nums[left]==0)
                        zero--;
                    left++;
                }
            }
            if(zero<=k)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }

            right++;
        }

        return  maxLen;

    }
}
