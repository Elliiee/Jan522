import java.util.ArrayList;
import java.util.List;

public class Q216 {
    //combination sum III
    private void backtrack(int k, int n, int start, List<Integer> level,
                           List<List<Integer>> results){
        if (k == 0 && n == 0){
            results.add(new ArrayList<>(level));
            return;
        }

        if (k == 0 || n == 0)
            return;

        for (int i = start; i <= 9; i++){
            level.add(i);
            backtrack(k - 1, n - i, i + 1, level, results);
            level.remove(level.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        backtrack(k, n, 1, level, results);
        return results;
    }
}
