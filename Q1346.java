import java.util.HashSet;
import java.util.Set;

public class Q1346 {
    // check if N and its double exist
    public boolean checkIfExist(int[] arr){
        Set<Integer> seen = new HashSet<>();
        for (int i : arr){
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }
}
