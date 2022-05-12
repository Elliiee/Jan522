import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q286 {
    private int empty = Integer.MAX_VALUE;
    private int gate = 0;
    private int wall = -1;
    private List<int[]> directions = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public void wallsAndGates(int[][] rooms){
        if (rooms.length == 0)
            return;
        for(int row = 0; row < rooms.length; row++){
            for (int col = 0; col < rooms[0].length; col++){
                if (rooms[row][col] == empty){
                    rooms[row][col] = distanceToNearestGate(rooms, row, col);
                }
            }
        }
    }

    private int distanceToNearestGate(int[][] rooms, int startRow, int endRow){
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, endRow});
        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];

                if (r < 0 || c < 0 || r >= m || c >= n
                        || rooms[r][c] == wall || distance[r][c] != 0)
                    continue;

                distance[r][c] = distance[row][col] + 1;
                if (rooms[r][c] == gate)
                    return distance[r][c];

                q.add(new int[]{r, c});
            }
        }
        return Integer.MAX_VALUE;
    }

    public void wallsAndGatesII(int[][] rooms){
        int m = rooms.length;
        int n = rooms[0].length;

        if (m == 0) return;

        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (rooms[row][col] == gate)
                    q.add(new int[]{row, col});
            }
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != empty)
                    continue;
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }
}
