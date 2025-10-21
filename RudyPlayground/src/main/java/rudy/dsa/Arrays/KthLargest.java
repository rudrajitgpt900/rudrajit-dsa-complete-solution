package rudy.dsa.Arrays;

import java.util.*;

public class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        if (nums.length == 1) pq.add(nums[0]);
        else {
            for (int num : nums) {
                if (pq.size() < k) {
                    pq.add(num);
                } else if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "KthLargest{" +
                "k=" + k +
                ", pq=" + pq +
                '}';
    }

    public int add(int val) {
        if(pq.size()< this.k){
            pq.add(val);
            return pq.peek();
        }
        if (val < pq.peek()) return pq.peek();
        pq.poll();
        pq.add(val);
        return pq.peek();
    }


    public static void main(String[] args) {
        KthLargest obj = new KthLargest(4, new int[]{5,1,2,7});
        System.out.println(obj.add(8));
        System.out.println(obj.add(2));
        System.out.println(obj.add(6));
        
        int[]arr = {2,3,1,2,3};
        Set<Integer>set = new LinkedHashSet<Integer>();

        //System.out.println(Arrays.toString(array));


    }
}
