import java.util.ArrayList;
import java.util.List;

public class Q119 {
    // pascal's triangle II
    public List<Integer> getRow(int rowIndex){
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j >= 1; j--){
                int temp = result.get(j - 1) + result.get(j);
                result.set(j, temp);
            }
            result.add(1);
        }
        return result;
    }
}
