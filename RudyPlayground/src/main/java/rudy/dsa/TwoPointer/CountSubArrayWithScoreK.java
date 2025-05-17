package rudy.dsa.TwoPointer;

public class CountSubArrayWithScoreK {

    public long countSubarrays(int[] arr, long k) {

        int n = arr.length;
        int left = 0;
        int right = 0;
        long cnt = 0;
        long score = 0;
        long sum = 0;

        while(right< n){
            sum+=arr[right];
            while((right-left+1)*sum >=k){
                sum-=arr[left];
                left++;
            }
            cnt+= right-left+1;
            right++;
        }
        return cnt;

    }
    public long fn(int[]arr , long k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        long cnt = 0;
        long score = 0;
        long sum = 0;

        while(right< n){
            sum+=arr[right];
            score = (right-left+1)*sum;
            if(score<k){
                cnt+= right-left+1;
            }
            while((right-left+1)*sum >=k){
                sum-=arr[left];
                left++;
            }

            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int []arr= {1,1,1};
        CountSubArrayWithScoreK obj = new CountSubArrayWithScoreK();
        System.out.println(obj.countSubarrays(arr,5));
    }

}
