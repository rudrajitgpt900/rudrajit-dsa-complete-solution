package rudy.playground.pg1;

public class QA1 {

/*                         0,1,2,3,4,5
*       [1,2,3,4,5,6]  -> [4,5,6,1,2,3]
find 2
* if(a[left]<=a[mid]{
*
* if tar>=a[l] && target< a[mid]{
* h=mid-1
* }
* else l= m+1
}
* else(

 */

    public static int findIndexRotatedArray(int[]arr, int target){

        int n = arr.length;
        int low =0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target)
                    return mid;
            if(arr[low]<=arr[mid]){
                if(target>=arr[low] && target<arr[mid])
                    high = mid -1;
                else
                    low = mid+1;
            }
            else{
                if(target>=arr[mid] && target<arr[high])
                    low= mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static boolean findingRotatedArray(int []arr, int target){

        int n = arr.length;
        int low =0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target)
                return true;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
            }
            else if(arr[low]<=arr[mid]){
                if(target>=arr[low] && target<arr[mid])
                    high = mid -1;
                else low = mid+1;
            }
            else{
                if(target>=arr[mid] && target<arr[high])
                    low= mid+1;
                else high = mid-1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2,3};


        int target = 16;
        System.out.println(findingRotatedArray(arr,target));

    }
}
