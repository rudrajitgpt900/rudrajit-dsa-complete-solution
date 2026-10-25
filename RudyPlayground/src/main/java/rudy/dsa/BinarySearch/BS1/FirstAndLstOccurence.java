package rudy.dsa.BinarySearch.BS1;

import java.util.*;

public class FirstAndLstOccurence {

    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        // Write your code here
        int ans =n;
        int low = 0;
        int high = n-1;
        while(low<=high){

            int mid = (low+high)/2;
            if(arr.get(mid)>=x){
                ans=mid;
                high = mid-1;
            }
            else{
                low= mid+1;
            }

        }
        return ans;
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int lb = lowerBound(arr, n, k);
        int firstOccur =-1;
        int lastOccur = -1;

        if(lb==n || arr.get(lb)!=k)
            return new int[]{firstOccur ,lastOccur};

        firstOccur = lb;

        while(lb <n-1 && arr.get(lb+1) ==k)
            lb++;
        lastOccur =lb;



        return new int[]{firstOccur ,lastOccur};
    }

    public static int[] countFrequency(int n, int x, int []nums){
        // Write your code here.
        int []visited = new int [x+1];
        for(int num :nums){
            visited[num]+=1;
        }

        int []ans= new int[n];
        int index =1;
        for(int i =0; i<n ; i++){
            ans[i] = visited[i+1];
        }

        return ans;
    }

    public static String reverseString(String str)
    {
        //Write your code here
        Stack<String> st = new Stack<>();
        String ans = "";
        String[] arr= str.split(" ");
        for(int i=0; i<arr.length;i++){
            if(i == arr.length-1){
                st.push(arr[i]);
            }
            else{
                st.push(arr[i]);
            }
        }
        while(st.size() !=1){
            ans = ans.concat(st.pop()).concat(" ");
        }
        ans= ans.concat(st.pop());
        return ans;
    }

    public static void main(String[] args) {
        String s = "Welcome to Coding Ninjas";
        System.out.println(reverseString(s));
    }
}
