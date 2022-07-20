public class Q209 {
    public int minSubArrayLen(int target, int[] nums){
        int index = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            while (sum >= target){
                min  = Math.min(min, i - index + 1);
                sum -= nums[index++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
