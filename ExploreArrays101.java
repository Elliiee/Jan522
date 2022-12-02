public class ExploreArrays101 {
    /*
    485 Max Consecutive Ones
    Given a binary array nums, return the maximum number of consecutive 1s in the array.
     */
    public int findMaxConsecutiveOnes(int[] nums){
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];

            if (nums[i] == 0)
                count = 0; // reset

            sum = Math.max(sum, count);
        }
         return sum;
    }
}
