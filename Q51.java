import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q51 {
    // N-Queen
    private int size;
    private List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n){
        size = n;
        char[][] emptyBoard = new char[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private List<String> createBoard(char[][] state){
        List<String> board = new ArrayList<>();
        for (int row = 0; row < size; row++){
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        return board;
    }

    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals,
                           Set<Integer> antiDiagonals, char[][] state){
        if (row == size){
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++){
            int currentDiagonal = row - col, currentAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currentDiagonal)
                    || antiDiagonals.contains(currentAntiDiagonal))
                continue;

            cols.add(col);
            diagonals.add(currentDiagonal);
            antiDiagonals.add(currentAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // if it comes to this step, it means it can't find the solution with the
            // queen being placed at the current row, so it has to remove it and travel back
            cols.remove(col);
            diagonals.remove(currentDiagonal);
            antiDiagonals.remove(currentAntiDiagonal);
            state[row][col] = '.';
        }
    }
}
