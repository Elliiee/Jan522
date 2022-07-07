public class Q1672 {
    // richest customer wealth
    // 就是比较每一行的和，找出最大和
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;
        int maxSum = 0;
        for (int i = 0; i < m; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += accounts[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
