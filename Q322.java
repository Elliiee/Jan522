import java.util.Arrays;

public class Q322 {
    //coin change
    public int coinChange(int[] coins, int amount){
        if (amount < 0) return 0;

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remain, int[] count){
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        if (count[remain - 1] != 0)
            return count[remain -1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int result = coinChange(coins, remain - coin, count);
            if (result >= 0 && result < min)
                min = 1 + result;
        }

        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[remain - 1];
    }

    public int coinChangeBottomUp(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
