/*
    122. Best time to buy and sell stock II
    You are give an integer array prices where prices[i] is the price of a given stock
    on the ith day.
        On each day, you may decide to buy and/ or sell the stock. you can only hold at
        most one share of the stock at any time. However, you can buy it then immediately
        sell it on the same day.
    find and return the maximum profit you can achieve.
 */
public class Q122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
