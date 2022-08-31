import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {
    //subsets II
    // array may contain duplicates, return all possible subsets
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> level,
                           List<List<Integer>> results){
        results.add(new ArrayList<>(level));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1])
                continue;

            level.add(nums[i]);
            backtrack(nums, i + 1, level, results);
            level.remove(level.size() - 1);
        }
    }
}
