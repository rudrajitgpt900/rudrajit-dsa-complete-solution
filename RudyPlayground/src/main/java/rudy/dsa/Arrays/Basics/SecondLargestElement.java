package rudy.dsa.Arrays.Basics;

import java.util.*;
import java.lang.*;
import java.io.*;
public class SecondLargestElement {

    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int[]ans =new int[2];
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for(int nums : a){

            if(nums > firstMax){
                secondMax =firstMax;
                firstMax =nums;

            }
            else if(nums< firstMax && nums > secondMax){
                secondMax =nums;
            }
        }


        for( int num : a){

            if(num < firstSmall){
                secondSmall = firstSmall;
                firstSmall= num;

            }
            else if(num > firstSmall && num < secondSmall){
                secondSmall =num;
            }
        }


        ans[0]= secondMax;
        ans[1] = secondSmall;
        return ans;
    }



}
