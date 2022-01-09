import java.util.HashMap;

/*
1 Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up tp target.
You may assume that each input would have exactly one solution, and you may not use the same
element twice.
You can return the answer in any order.
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int n = target - nums[i];
            if (map.containsKey(n)){
                return new int[]{i, map.get(n)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
