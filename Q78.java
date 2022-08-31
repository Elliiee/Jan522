import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results , List<Integer> level,
                           int[] nums, int start){
        results.add(new ArrayList<>(level));
        for (int i = start; i < nums.length; i++){
            level.add(nums[i]);
            backtrack(results, level, nums, i + 1);
            level.remove(level.size() - 1);
        }
    }
}
