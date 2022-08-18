import java.util.HashSet;
import java.util.Set;

public class Q694 {
    //Number of Distinct Islands
    private void dfs(int[][] grid, int row, int col, StringBuilder sb, String dir){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return;
        sb.append(dir);
        grid[row][col] = 0;
        dfs(grid, row - 1, col, sb, "up");
        dfs(grid, row + 1, col, sb, "down");
        dfs(grid, row, col - 1, sb, "left");
        dfs(grid, row, col + 1, sb, "right");
        sb.append("back");
    }

    public int numDistinctIslands(int[][] grid){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
}
