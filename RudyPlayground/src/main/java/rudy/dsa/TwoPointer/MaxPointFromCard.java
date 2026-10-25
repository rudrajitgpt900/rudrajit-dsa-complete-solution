package rudy.dsa.TwoPointer;

public class MaxPointFromCard {

    //[1,2,3,4,5,6,1]
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0;
        int rsum =0;
        int maxScore=0;
        int currentScore = 0;
        for(int i=0;i<k;i++)
            lsum+=cardPoints[i];
        int rIndex = n-1;
        maxScore = lsum;
        for(int i =k-1; i>=0; i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rIndex];
            rIndex--;
            currentScore=lsum+rsum;
            maxScore=Math.max(maxScore,currentScore);
        }
        return maxScore;
    }

}
