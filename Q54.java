import java.util.ArrayList;
import java.util.List;

public class Q54 {
    // spiral matrix
    public List<Integer> spiralOrder(int[][] matrix){
        int VISITED = 101; // constrains says -100 < x <100, so here use 101 just for marking purpose
        int rows = matrix.length, column = matrix[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // sequence matters
        int currentDirection = 0; // initial direction: moving right
        int changeDirection = 0; // the number of times we change the direction
        int row = 0, col = 0;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;

        //place holder
        return result;
    }
}
