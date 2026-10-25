package rudy.dsa.Arrays.Easy;

import java.util.Set;
import java.util.TreeSet;

public class FormSmallestInteger {

    public int minNumber(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int x: nums1) set1.add(x);
        for(int y: nums2)set2.add(y);
        int ans =Integer.MAX_VALUE;
        for(int i =1; i<=9; i++){
            if(set1.contains(i) && set2.contains(i))
                return i;
            String s1="", s2="";
            Integer n1 = set1.first();
            Integer n2 = set2.first();
            if(n1<n2){
                s1 = Integer.toString(n1);
                s2 = Integer.toString(n2);
            }
            else{
                s1 = Integer.toString(n2);
                s2 = Integer.toString(n1);
            }

            String str = s1 + s2;
            ans = Integer.parseInt(str);
        }

        return ans;
    }

    public static void main(String[] args) {
        FormSmallestInteger obj = new FormSmallestInteger();
        int[]num1 ={1,5,8,4};
        int[]num2 = {2,7,9};

        System.out.println(obj.minNumber(num1,num2));
    }
}
