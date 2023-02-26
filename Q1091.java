import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q1091 {
    //02/25/23
    class State{
        int row;
        int col;
        int steps;
        State(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    private static final int[][] directions = new int[][]{
            {-1, -1}, {-1, 0}, {0, -1}, {-1, 1},
            {1, 1}, {1, 0}, {0, 1}, {1, -1}
    };

    private boolean valid(int row, int col, int[][] grid){
        return 0 <= row && row <grid.length
                && 0 <= col && col < grid[0].length
                && grid[row][col] == 0;
    }

    public int shortestPathIII(int[][] grid){
        if (grid[0][0] == 1) return -1; //top left cell is not open, return -1

        int n = grid.length; //this is a square matrix, so m == n

        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0, 1));

        while (!queue.isEmpty()){
            State state = queue.poll();
            int row = state.row, col = state.col, steps = state.steps;

            if (row == n - 1 && col == n - 1) return steps; //reached the bottom right cell return the answer

            for (int[] dir : directions){
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]){
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }
        return -1;
    }


    // shortest path in binary matrix


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
