package rudy.dsa.Arrays;

public class NumArray2 {

    int n;
    int []preF;
    int []nums;

    NumArray2(int[]nums){
        this.nums= nums;
        this.n = nums.length;
        this.preF= new int[n+1];

        for (int i = 0; i <n ; i++) {
            preF[i+1]= preF[i]+this.nums[i];
        }

    }
    public void update(int index, int val) {

        int oldVal = this.nums[index];//3
        this.nums[index]= val;//2
       // num[]= {1,2,5}
        int diff = val - oldVal;//-1
        for (int i = index+1 ; i < preF.length; i++) {
            preF[i] += diff;
        }


    }
    public int sumRange(int left, int right) {
        return preF[right+1]-preF[left];
    }

    public static void main(String[] args) {
        int[]nums = {1,3,5};
        NumArray2 numArray = new NumArray2(nums);
        System.out.println( numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        System.out.println( numArray.sumRange(0, 2));
    }
}
