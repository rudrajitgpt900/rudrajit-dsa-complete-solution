package rudy.dsa.DynamicProgramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestIncreasingPath {

    public static final int[][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public static int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][]dp = new Integer[m][n];
        int ans = Integer.MIN_VALUE;
        int prev = -1;
        for(int i = 0; i<m; i++){
            for (int j=0; j<n; j++){
               ans = Math.max(ans , dfs(i , j , matrix , m , n , dp));
            }
        }
        return ans;
    }

    private static int dfs(int i, int j, int[][] matrix, int m, int n, Integer[][] dp) {

        if(dp[i][j]!=null)
            return dp[i][j];
        int len = 1;

        for(int[]arr : dir){
            int nR = i + arr[0];
            int nC = j + arr[1];
            if(nR>=0 && nC >=0 && nR<m && nC<n && matrix[nR][nC]>matrix[i][j]){
                len = Math.max(len , 1 + dfs(nR,nC, matrix, m ,n, dp));
            }
        }

        return dp[i][j]=len;
    }


    public static void main(String[] args) {
        int [][]arr = {{9,9,4},{6,6,8},{2,1,1}};
       // System.out.println(longestIncreasingPath(arr));
        List<List<Integer>>lists= List.of(List.of(1,2,3),List.of(5,3,7,8),List.of(2,41,10,12));

        List<Integer> sumOfSubList = lists.stream()
                            .map(sublist -> sublist.stream()
                                 .mapToInt(Integer::intValue)
                                    .sum())
                            .toList();

        List<List<Integer>> sortedList = lists.stream()
                .map(sub -> sub.stream().sorted(Comparator.comparingInt(a -> a))
                        .toList())
                .toList();

        List<Integer> maxFromEach = lists.stream()
                .map(sub -> sub
                        .stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt())
                .toList();
        Map<String, List<String>> map = Map.of( "Alice", List.of("Volvo","Tesla", "Toyota"), "Bob",List.of("Volvo"), "George",List.of("Tesla", "Toyota"));


      var peoples=  map.entrySet()
              .stream()
              .filter(entry-> entry.getValue().size()==1)
              .map(entry-> entry.getKey())
              .toList();
        System.out.println(peoples);
        System.out.println(sumOfSubList);
        System.out.println(sortedList);
        System.out.println(maxFromEach);

    }
}
