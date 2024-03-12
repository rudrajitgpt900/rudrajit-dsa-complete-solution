package rudy.dsa.Arrays.Easy;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int singleNumber =0;

        for(int el : nums){
            singleNumber = singleNumber ^ el;
        }

        return singleNumber;

    }
}
