package rudy.dsa.Greedy;

import java.util.Arrays;

public class AssignCookies {

    public  static int findContentChildren(int[] g, int[] s) {

        int left =0;
        int right =0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        while(left<m && right<n){
            int greed = g[right];
            if(s[left] >= greed){
                right++;
            }
            left++;
        }
        return right;
    }

    public static void main(String[] args) {
        int[]g={1,2 ,3};
        int[]s = {1 , 1};
        System.out.println(findContentChildren(g,s));
    }
}
