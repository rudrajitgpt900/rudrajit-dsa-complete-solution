package rudy.dsa.Greedy;

public class Candy {

    //1,0,2
    //1 , 1 , 2
    // 2 ,1 , 1
    // 1+2+1
    public static int candy(int[] ratings){

        int n = ratings.length;
        int ans =0;
        int []lsum= new int [n];
        int []rsum = new int[n];

        lsum[0]=1;
        rsum[n-1]=1;

        for(int i=1; i<n; i++){
            int currentRating = ratings[i];
            int prevousRating = ratings[i-1];
            if(currentRating > prevousRating){
                lsum[i]= lsum[i-1]+1;
            }
            else lsum[i]=1;
        }

        for(int i = n-2; i>=0; i--){
            int currentRating = ratings[i];
            int nextRating = ratings[i+1];
            if(currentRating>nextRating){
                rsum[i]= rsum[i+1] +1;
            }
            else{
                rsum[i]=1;
            }
        }

        for(int i =0; i< n; i++){
            ans+= Math.max(lsum[i], rsum[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        int []a= {1,0,2};
        System.out.println(candy(a));
    }
}
