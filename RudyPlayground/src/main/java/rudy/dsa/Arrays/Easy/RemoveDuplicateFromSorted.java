package rudy.dsa.Arrays.Easy;

public class RemoveDuplicateFromSorted {

    public static int removeDuplicates(int[] nums) {

        // Write your code here.
        int n = nums.length;
        int j =1;
        for(int i =1; i<n; i++){
            if(nums[i] != nums[i-1]){
                nums[j]= nums[i-1];
                j++;
            }
        }
        return j;
    }
}
