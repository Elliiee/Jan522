import java.util.LinkedList;
import java.util.Queue;

public class Q200 {
    /*
    DFS
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int num = 0;

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    num++;
                    dfs(grid, r, c);
                }
            }
        }

        return num;
    }

    private void dfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /*
    BFS
     */
    public int numIslandsBFS(char[][] grid){
        if (grid == null || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int num = 0;

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    num++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * n + c);
                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 > 0 && grid[row - 1][col] == '1'){
                            neighbors.add((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m  && grid[row + 1][col] == '1'){
                            neighbors.add((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 > 0 && grid[row][col - 1] == '1'){
                            neighbors.add(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 > 0 && grid[row][col + 1] == '1'){
                            neighbors.add(row* n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }

    /*
    Union Find
     */
    class UnionFind200{
        int count;
        int[] root;
        int[] rank;

        public UnionFind200(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            root = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == '1'){
                        root[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i){
            if (root[i] != i)
                root[i] = find(root[i]);
            return root[i];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                if (rank[rootX] > rank[rootY])
                    root[rootY] = rootX;
                else if (rank[rootX] < rank[rootY])
                    root[rootX] = rootY;
                else{
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public int getCount(){
            return count;
        }
    }

    public int numIslandsUnionFind(char[][] grid){
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        UnionFind200 uf = new UnionFind200(grid);
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1')
                        uf.union(r * n + c, (r-1) * n + c);
                    if (r + 1 < m && grid[r+1][c] == '1')
                        uf.union(r * n + c, (r+1) * n + c);
                    if (c - 1 >= 0 && grid[r][c-1] == '1')
                        uf.union(r * n + c, r * n + c - 1);
                    if (c + 1 >= 0 && grid[r][c+1] == '1')
                        uf.union(r * n + c, r * n + c + 1);
                }
            }
        }
        return uf.getCount();
    }
}
