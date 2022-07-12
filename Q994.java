import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    // rotting oranges
    public int orangeRotting(int[][] grid){
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;

        // put the position of the rotten oranges in queue
        // and also count the number of fresh oranges
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    countFresh++;
            }
        }

        if (countFresh == 0)
            return 0; // no fresh oranges to contaminate

        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();
                for (int[] direction : directions){
                    int r = cell[0] + direction[0];
                    int c = cell[1] + direction[1];

                    if (r < 0 || c < 0 || r >= rows || c >= cols ||
                        grid[r][c] == 0 || grid[r][c] == 2)
                        continue;

                    grid[r][c] = 2;
                    queue.offer(new int[]{r, c});
                    countFresh--;
                }
            }
        }

        return countFresh == 0 ? count - 1 : -1;
    }
}
