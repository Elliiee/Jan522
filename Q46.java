import java.util.ArrayList;
import java.util.List;

public class Q46 {
    //46 permutation
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(nums, permutes, permuteList, visited);

        return permutes;
    }
    private void backtracking(int[] nums, List<List<Integer>> permutes,List<Integer> permuteList,
                              boolean[] visited){
        if (permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i]) continue;

            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(nums, permutes, permuteList, visited);

            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
