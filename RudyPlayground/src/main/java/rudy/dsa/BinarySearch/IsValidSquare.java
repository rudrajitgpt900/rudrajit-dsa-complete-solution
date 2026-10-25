package rudy.dsa.BinarySearch;

public class IsValidSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 1)return true;

        long low =2;
        long high= num/2;
        while(low<=high){
            long mid = (low+high)/2;
            if(mid*mid ==num)return true;
            if(mid*mid<num)low =mid+1;
            else high = mid -1;

        }
        return false;
    }
}
