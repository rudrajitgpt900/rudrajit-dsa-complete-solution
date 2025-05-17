package rudy.dsa.StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {


    public int maximalRectangle(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;

        /* Prefix sum matric to store heights
        for different ground levels */
        int[][] prefixSum = new int[n][m];

        // Fill up the prefix sum matrix column wise
        for (int j = 0; j < m; j++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];

                // If there is no base present
                if (matrix[i][j] == 0) {
                    prefixSum[i][j] = 0;
                    sum = 0;
                } else {
                    // Store the height
                    prefixSum[i][j] = sum;
                }
            }


        }
        for(int[]height : prefixSum){
            area = Math.max(area , largestRectangleArea(height));
        }
        return area;
    }
    public int largestRectangleArea(int[] heights) {

        int area=0;
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        int[]nse=nse(heights);
        int[]pse = pse(heights);

        for(int i= 0; i<n ; i++){
            area = heights[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;

    }

    public int[] nse(int[]arr){
        //n=6
        //[2, 1, 5, 6, 2, 3]
        //[0, 1, 2, 3, 4, 5]
        //nse = [1,6,3,4,n,n]
        int n=arr.length;
        int []ans= new int[n];
        Stack<Integer>stack=new Stack<>();
        ans[n-1]= n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            int currentInd = stack.peek();//5
            if(arr[i]>arr[currentInd]){
                ans[i]=currentInd;
            }
            else {
                while (!stack.empty() && arr[i]<=arr[stack.peek()]){
                    stack.pop();
                }
                ans[i]= stack.isEmpty()?n:stack.peek();
            }
            stack.push(i);
        }


        return ans;

    }

    public int[]pse(int[]arr){
        int n=arr.length;
        int []ans= new int[n];
        /*
        * {2, 1, 5, 6, 2, 3};
        * [0, 1, 2, 3, 4, 5]
        * pse=[-1, -1 , 1 , 2 , 1 , 4]
        * */
        ans[0]=-1;
        Stack<Integer>stack= new Stack<>();
        stack.push(0);
        for(int i=1; i<n; i++){
            int currentInd = stack.peek();
            if(arr[i]>arr[currentInd]){
               ans[i]=currentInd;
            }
            else{
                while (!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                    stack.pop();
                }
                ans[i]= stack.isEmpty()?-1:stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr={1, 1};
        int[][]m={{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        LargestRectangleHistogram histogram= new LargestRectangleHistogram();
        System.out.println(histogram.maximalRectangle(m));
        System.out.println((histogram.largestRectangleArea(arr)));
    }
}
