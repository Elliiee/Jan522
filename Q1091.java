import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q1091 {
    // shortest path in binary matrix
    private static final int[][] directions = new int[][]{
            {-1, -1}, {-1, 0}, {0, -1}, {-1, 1},
            {1, 1}, {1, 0}, {0, 1}, {1, -1}
    };

    private List<int[]> getNeighbours(int row, int col, int[][] grid){
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
                || grid[newRow][newCol] != 0)
                continue;

            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

    public int shortestPathBinaryMatrix(int[][] grid){
        int m = grid.length; int n = grid[0].length;
        // first, check if the start and end are 0
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1; // overwrite the input
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];

            if (row == m - 1 && col == n - 1)
                return distance;

            for (int[] neighbour : getNeighbours(row, col, grid)){
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        return -1; // no clear path 
    }

    // no over writing the value
    public int shortestPathBinaryMatrixII(int[][] grid){
        int m = grid.length; int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // put distance on the queue

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];

            if (row == m - 1 && col == n - 1)
                return distance;

            for (int[] neighbour : getNeighbours(row, col, grid)){
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                if(visited[neighbourRow][neighbourCol])
                    continue;
                visited[neighbourRow][neighbourCol] = true;
                queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
            }
        }

        return -1; // no clear path
    }
}
