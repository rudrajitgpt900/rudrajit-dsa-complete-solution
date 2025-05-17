package rudy.dsa.DynamicProgramming;

public class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        if(n==1)
            return true;
        if(isPerfectSquare(n))
            return true;
       boolean []dp = new boolean[n+1]; //this dp represents at ith index can Alice win
       dp[0]=false;
       dp[1]= true;
       for(int i = 2; i<=n; i++){
           //Alice can pick 1 till i
           for(int j =1 ; j*j<=i; j++){
               if(!dp[i - (j * j)]){
                   dp[i]= true;
                   break;
               }
           }
       }


       return dp[n];
    }

    private boolean fn(int pile , int player){
        if(pile<=0 && player ==1)
            return false;
        if(pile<=0 && player==0)
            return true;
        if(pile==2 && player==0)
            return true;
        if(pile ==2 && player ==1)
            return false;
        if(isPerfectSquare(pile)){
            return player == 1;
        }
        if(player == 1)
            return fn(pile-closestSquare(pile) , 0);

        return fn(pile - closestSquare(pile),1);
    }

    public boolean isPerfectSquare(int n){
        if(n<0)
            return false;
        int sqrt = (int)Math.sqrt(n);
        return n==sqrt*sqrt;
    }

    public int closestSquare(int n){
        if(n<0)
            return 0;
        int sqrt = (int)Math.sqrt(n);
        return sqrt*sqrt;
    }

    public static void main(String[] args) {
        StoneGameIV obj = new StoneGameIV();
        System.out.println(obj.winnerSquareGame(4));
    }
}
