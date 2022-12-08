public class Q59 {
    /*
    Given a positive integer n, generate an n x n matrix filled with elements from
    1 to n-square spiral order.
     */
    public int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];

        if (n == 0) return matrix;

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd){
            for (int j = colStart; j < colEnd; j++){
                matrix[rowStart][j] = num++;
            }
            rowStart++; // increase the row

            for (int i = rowStart; i < rowEnd; i++){
                matrix[i][colEnd] = num++;
            }
            colEnd--; //spiral

            for (int j = colEnd; j >= colStart; j--){
                //if (rowStart <= rowEnd)
                    matrix[rowEnd][j] = num++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--){
                //if (colStart <= colEnd)
                    matrix[i][colStart] = num++;
            }
            colStart++;
        }

        return matrix;
    }
}
