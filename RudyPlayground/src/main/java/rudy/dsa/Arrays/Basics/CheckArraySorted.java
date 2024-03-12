package rudy.dsa.Arrays.Basics;
import java.io.*;
import java.util.*;

import  java.lang.*;

public class CheckArraySorted {

    public static int isSorted(int n, int []a) {
        // Write your code here.

        if(n==1)
            return 1;
        if(n==0) return 0;

        for(int i =1;i<n;i++){
            if(a[i]<a[i-1])
                return 0;
        }
        return 1;

    }



}
