package rudy.dsa.Arrays.Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        if(l>=r)
            return;
        int mid = (l+r)/2;
        mergeSort(arr ,l ,mid);
        mergeSort(arr,mid+1 ,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }


    public static void main(String[] args) {
        int[]arr = new int[]{2,1,5,3,4};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
