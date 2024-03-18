package rudy.dsa.Arrays.Medium;

public class StockBuyAndSell1 {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min= prices[0];

        for(int i=1; i< prices.length ; i++){
            int currentProfit= prices[i] -min;
            profit= Math.max(profit , currentProfit);
            min= Math.min(min , prices[i]);
        }

        return profit;
    }
}
