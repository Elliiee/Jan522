import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    //Combination Sum II
    private void backtrack(List<Integer> level, List<List<Integer>> results, boolean[] visited,
                           int start, int target, int[] nums){
        if (target == 0){
            results.add(new ArrayList<>(level));
            return;
        }

        for (int i = start; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            if (nums[i] <= target){
                level.add(nums[i]);
                visited[i] = true;

                backtrack(level, results, visited, i + 1, target - nums[i], nums);

                level.remove(level.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), results, new boolean[nums.length], 0, target, nums);
        return results;
    }
}
