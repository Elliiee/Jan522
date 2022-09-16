public class Q188 {
    //best time to buy and sell stock IV
    private int[] prices;
    private int[][][] memo;

    private int dp(int i, int transactionRemaining, int holding){
        if (transactionRemaining == 0 || i == prices.length)
            return 0; // base case

        if (memo[i][transactionRemaining][holding] == 0){
            int doNothing = dp(i + 1, transactionRemaining, holding);
            int doSomething;

            if (holding == 1){
                // when you hold the stock, do something means to sell
                doSomething = prices[i] + dp(i + 1, transactionRemaining - 1, 0);
            } else {
                // when you are not holding the stock,
                // do something means to buy
                doSomething = -prices[i] + dp(i + 1, transactionRemaining, 1);
            }

            memo[i][transactionRemaining][holding] = Math.max(doNothing, doSomething);
            // recurrence relation to choose for each state
        }

        return memo[i][transactionRemaining][holding];
    }

    public int maxProfit(int k, int[] prices){
        this.prices = prices;
        this.memo = new int[prices.length][k + 1][2]; // remember to add 1 to k because index starts from 0;
        return dp(0, k, 0);
    }

    public int maxProfitBottomUp(int k, int[] prices){
        int n = prices.length;
        int dp[][][] = new int[n + 1][k + 1][2];

        for (int i = n - 1; i >= 0; i--){
            for (int transactionRemaining = 1; transactionRemaining <= k; transactionRemaining++){
                for (int holding = 0; holding < 2; holding++){
                    int doNothing = dp[i+1][transactionRemaining][holding];
                    int doSomething;

                    if (holding == 1){
                        // sell
                        doSomething = prices[i] + dp[i+1][transactionRemaining - 1][0];
                    } else {
                        // buy
                        doSomething = -prices[i] + dp[i+1][transactionRemaining][1];
                    }

                    // recurrence relation
                    dp[i][transactionRemaining][holding] = Math.max(doNothing, doSomething);
                }
            }
        }
        return dp[0][k][0];
    }
}
