public class Q695 {
    //max area of island
    private int m, n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null && grid.length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col){
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1)
            return 0;

        grid[row][col] = 0;
        int area = 1;
        for (int[] d : directions){
            area += dfs(grid, row + d[0], col + d[1]);
        }
        return area;
    }
}
