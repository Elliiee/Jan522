/*
48 Rotate Image
You are given a nxn 2d matrix representing an image, rotate the image by 90 degrees.
you have to rotate the image in place, which means you have to modify the input 2D matrix
directly. Do Not allocate another 2D matrix and do the rotation.
 */
public class Q48 {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 -j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
