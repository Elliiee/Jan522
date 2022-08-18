public class Q463 {
    //island perimeter
    //The idea is each time, we encounter a boundary, count++;
    public int islandPerimeter(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    for (int[] d : directions){
                        int row = i + d[0], col = j + d[1];

                        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
