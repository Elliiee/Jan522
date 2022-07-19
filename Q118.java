import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Q118 {
    // pascal's triangle
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int row = 1; row < numRows; row++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row - 1);
            currRow.add(1); // the first element is always 1

            for (int j = 1; j < row; j++){
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currRow.add(1);// the last element is always 1
            triangle.add(currRow);
        }
        return triangle;
    }
}
