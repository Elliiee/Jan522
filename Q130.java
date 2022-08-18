public class Q130 {
    //surrounded regions
    public void solve(char[][] board) {
        if (board == null || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0 ; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++){
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != 'O')
            return;
        board[row][col] = '#';
        dfs(board, row-1, col);
        dfs(board, row+1, col);
        dfs(board, row, col-1);
        dfs(board, row, col+1);
    }
}
