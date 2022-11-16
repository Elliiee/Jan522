public class Q64 {
    /*
    64 Minimum Path Sum
    Given an m x n grid filled with non-negative numbers, find a path from top left to bottom
    right, which minimizes the sum of all numbers along its path.
    Note you can only move either down or right at any point in time.
     */

    /*
    Approach 1 Brute Force
    This method involves recursion. For each element, we consider two paths, rightwards and
    downwards and find the minimum sum out of those two. It specifies whether we need to take
    a right step or downward step to minimize the sum.
    cost(i,j)=grid[i][j]+min(cost(i+1,j),cost(i,j+1))
     */

    public int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--){
            for (int j = grid[0].length - 1; j >= 0; j--){
                if (i == grid.length - 1 && j != grid[0].length - 1){
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1){
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
