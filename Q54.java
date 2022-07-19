import java.util.ArrayList;
import java.util.List;

public class Q54 {
    // spiral matrix
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, left = 0, right = n - 1, down = m -1; // 4 boundaries

        while (up <= down && left <= right){
            for (int col = left; col <= right; col++){ // left to right
                result.add(matrix[up][col]);
            }
            up++;

            for (int row = up; row <= down; row++){
                result.add(matrix[row][right]);
            }
            right--;

            if (up <= down){
                for (int col = right; col >= left; col--){
                    result.add(matrix[down][col]);
                }
            }
            down--;

            if (left <= right){
                for (int row = down; row >= up; row--){
                    result.add(matrix[row][left]);
                }
            }
            left++;
        }
        return result;
    }
}
