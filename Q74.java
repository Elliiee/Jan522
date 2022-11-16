public class Q74 {
    /*
    74 Search a 2D matrix
    Search value in an m x n matrix.
    Integers in each row are sorted from left to right.
    The first integer of each row is larger than the last integer of the previous row.
     */

    /*
    Approach 1 binary search
    Notice that the input of the matrix can be considered
    as a sorted array of length m x n.
    row = index / n;
    column = index % n;
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0) return false;

        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = left + 1;
            }
        }
        return false;
    }
}
