public class Q348 {
    /*
    Design Tic-Tac-Toe
     */
    private int[][] board;
    private int n;

    //1. for a given n, initialized a 2-dimensional array board of size n * n with the values of all
    // elements set to 0;
    public Q348(int n){
        board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player){
        //every move, mark the row and col on the board with the current player's id.
        board[row][col] = player;
        //check if the player wins;
        if (checkRow(row, player) || checkColumn(col, player) || (row == col && checkDiagonal(player))
        || (col == n - row - 1 && checkAntiDiagonal(player))){
            return player;
        }
        //no wins
        return 0;
    }

    //check if all the cells from the current given row are marked by the player
    private boolean checkRow(int row, int player){
        for (int col = 0; col < n; col++){
            if (board[row][col] != player){
                return false;
            }
        }
        return true;
    }

    //check if the current player marked all cells from the current column;
    private boolean checkColumn(int col, int player){
        for (int row = 0; row < n; row++){
            if (board[row][col] != player){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player){
        for (int row = 0; row < n; row++){
            if (board[row][row] != player){
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player){
        for (int row = 0; row < n; row++){
            if (board[row][n - row - 1] != player){
                return false;
            }
        }
        return true;
    }
}
