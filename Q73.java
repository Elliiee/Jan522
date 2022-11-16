public class Q73 {
    /*
    73 Set Matrix Zeros
    Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
    You must do it in place.
     */

    /*
    The trick is we need to modify the given matrix in place.
    The idea is that we can use the first cell of every row and column as a flag. This flag
    would determine whether a row or column has been set to zero. This means for every cell
    instead of going to M + N cells and setting it to zero we just set the flag in two cells.
     */
    public void setZeros(int[][] matrix){
        boolean isCol = false;
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            //Since first cell for both first row and first column is the same.
            //We can use an additional variable for either the first row/column.
            //For this solution we are using an additional variable for the first
            //column and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < c; j++) {
                //If an element is zero, we set te first element of the row and column to zero
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

            //Iterate over the array once again and using the first row and first column to update
            for (int i = 1; i < r; i++){
                for (int j = 1; j < c; j++){
                    if (matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }

            //check if the first row needs to be set to zero as well
            if(matrix[0][0] == 0){
                for (int j = 0; j < c; j++){
                    matrix[0][j] = 0; // first row
                }
            }

            //check if the first column needs to be set to zero as well
            if (isCol){
                for (int i = 0; i < r; i++){
                    matrix[i][0] = 0;
                }
            }

    }
}
