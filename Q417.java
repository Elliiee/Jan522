import java.util.LinkedList;
import java.util.List;

public class Q417 {
    //pacific atlantic water flow
    private void dfs(int[][] matrix, boolean[][] visited, int height, int r, int c){
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] < height)
            return;

        visited[r][c] = true;
        dfs(matrix, visited, matrix[r][c], r-1, c);
        dfs(matrix, visited, matrix[r][c], r+1, c);
        dfs(matrix, visited, matrix[r][c], r, c-1);
        dfs(matrix, visited, matrix[r][c], r, c+1);
    }

    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return null;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, pacific, Integer.MIN_VALUE, i, n-1);
        }
        for (int j = 0; j < n; j++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
            dfs(matrix, pacific, Integer.MIN_VALUE, m-1, j);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j])
                    result.add(new int[]{i, j});
            }
        }

        return result;
    }
}
