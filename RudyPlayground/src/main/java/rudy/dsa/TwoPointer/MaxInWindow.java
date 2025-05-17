package rudy.dsa.TwoPointer;

import rudy.dsa.DesignDS.MaxStack;

import java.util.*;

public class MaxInWindow {

    public ArrayList<Integer>solve(ArrayList<Integer>nums , int k){
        ArrayList<Integer>ans = new ArrayList<>();
        int left =0;
        int right = k-1;

        while (right< nums.size()){
            int max =0;
            while (left <= right){
                max= Math.max(nums.get(left),max);
                left++;

            }
            ans.add(max);
            right++;
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if(n==1)
            return nums;
        List<Integer>list = new ArrayList<>();

        MaxStack stack = new MaxStack();
        int left = 0;
        int right = 0;
        while (right<n){
            if(stack.getSize()==k){
                list.add(stack.getMax());
                stack.popLast();
            }
            else{
                stack.push(nums[right]);
                right++;
            }


        }
        stack.print();
        list.add(stack.top());
        int ans[] = new int[list.size()];
        for(int i = 0;i< ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[]arr = {7,2,4};



        //[3,3,5,5,6,7]
        int k = 2;
        MaxInWindow max = new MaxInWindow();
        System.out.println(Arrays.toString(max.maxSlidingWindow(arr, k)));

    }
}
