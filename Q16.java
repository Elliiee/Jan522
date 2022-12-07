import java.util.Arrays;

public class Q16 {
    /*
    Given an integer array nums of length n and an integer target, find three integers
    in nums such that the sum is closest to target. Math.min
    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.
     */

    /*
    two pointers
    Note that we can't use a hash set because we are not finding a specific target.
    Just some answer closest to the target.
     */

    public int threeSumClosest(int[] nums, int target){
        //initialize the minimum difference diff with a large value
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        //sort the array
        Arrays.sort(nums);
        for (int i = 0; i < len && diff != 0; i++){
            int lo = i + 1;
            int hi = len - 1;
            while (lo < hi){
                int sum =  nums[i] + nums[lo] + nums[hi];
                //update the difference if you find a smaller one
                if (Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if (sum < target){
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return target - diff;
        //return the value of the sum with the smallest difference
    }
}
