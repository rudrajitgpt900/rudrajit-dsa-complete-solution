package rudy.dsa.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {


    public List<Integer> spiralOrder(int[][] a) {

        int n = a.length;
        int m = a[0].length;
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int left =0;
        int bottom = n-1;
        int right = m-1;
        int index =0;
        while(top<=bottom && left <= right){

            //right
            for(int i =left ; i<= right ; i++){
                ans.add(a[top][i]) ;

            }
            top++;
            for(int i =top ; i<=bottom; i++){
                ans.add(a[i][right]) ;
            }
            right--;

            if(top<=bottom){
                for(int i = right; i>= left; i--){
                    ans.add(a[bottom][i]) ;
                }
                bottom--;
            }
            if(left<=right){
                for(int i =bottom; i>=top ; i--){

                    ans.add(a[i][left]) ;

                }
                left++;
            }
        }

        return ans;


    }
}
