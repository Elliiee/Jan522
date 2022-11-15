import java.util.*;

public class Q15 {
    /* 15 3 Sum
    Given an integer array nums, return all the triplets
    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
    and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
     */
    public List<List<Integer>> threeSum(int[] nums){
        //sort the input array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //Iterate through the array:
        //If the current value is greater than 0, than remaining cannot
        //sum to 0, not the fit. Break from the loop, and go try the next one.
        //If the current value is the same as the one before, skip it. Because
        //question description says no duplicates
        // otherwise, call twoSumII method to get the result;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            if (i == 0 || nums[i - 1] != nums[i]){
                twoSumII(nums, i, result);
            }
        }
        return result;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> result){
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi){
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0){
                lo++;
            } else if (sum > 0){
                hi--;
            } else {
                result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                while(lo < hi && nums[lo] == nums[lo - 1]){
                    lo++;
                }
            }
        }
    }
    //Memory Limit Exceeded

    private void twoSum(int[] nums, int i, List<List<Integer>> result){
        HashSet<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++){
            int complement = -nums[j] - nums[i];
            if (set.contains(complement)){
                result.add(Arrays.asList(nums[i], nums[j], complement));

                while (j + 1 < nums.length && nums[j] == nums[j + 1]){
                    j++;
                }
                set.add(nums[j]);
            }
        }
    }

    //We can adapt the hashset approach above to work for an unsorted array.
    //we can put a combination of 3 values into a hashset to avoid duplicates.
    // values in a combination should be ordered. Otherwise, we can have results
    // with the same values in the different positions;
    public List<List<Integer>> threeSumIII(int[] nums){
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (duplicates.add(nums[i])){
                for (int j = i + 1; j < nums.length; j++){
                    int complement = -nums[i] - nums[j];
                    if (map.containsKey(complement) && map.get(complement) == i){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    map.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
