package rudy.dsa.DynamicProgramming;

public class JumpGameI {

    public static boolean canJump(int[] nums) {
        //[2,3,1,1,4]
        int n = nums.length;
        if(n==1)
            return true;
        int max = 0;
        for(int i =0; i<n-1 && max>=i; i++){
           max = Math.max(max, i+nums[i]);
           if(max>=n-1)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[]arr= {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
