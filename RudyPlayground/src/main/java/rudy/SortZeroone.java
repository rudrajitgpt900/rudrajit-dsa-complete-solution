package rudy;

import java.util.*;

public class SortZeroone {


    public static void sort(int[]arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i!=j){
            if(arr[i]== arr[j]){
                i++;
                j--;
            }
            else{
                if(arr[i] > arr[j]){
                    //swap
                    var temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
                else{

                    j--;
                }
            }
        }


        System.out.println(Arrays.toString(arr));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        nge[n-1]= -1;
        stack.push(nums2[n-1]);
        map.put(nums2[n-1],nge[n-1]);
        for(int i = n-2; i>=0;i--){
            int currentElement = nums2[i];
            int top = stack.peek();
            if(currentElement<top){
                nge[i]=top;
            }
            else{
                while(!stack.isEmpty()&&currentElement>stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    nge[i] = -1;
                }

                else{

                    nge[i]= stack.peek();
                }


            }
            stack.push(currentElement);
            map.put(currentElement , nge[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i =0;i< ans.length;i++){
            int key = nums1[i];
            ans[i]= map.get(key);
        }


        return ans;

    }

    public static void main(String[] args) {
        int []arr = {0,1,1,0,1,0,0,0};
        sort(arr);
        List<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println("Before :"+list);
        list.remove(list.size()-1);
        System.out.println("After :"+list);
    }
}
