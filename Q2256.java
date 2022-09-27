public class Q2256 {
    //minimum average difference
    public int minimumAverageDiff(int[] nums){
        int res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;

        for (int num : nums){
            sum += num;
        }

        for (int i = 0; i < nums.length; i++){
            leftSum += nums[i];
            rightSum = sum - leftSum;

            long diff = Math.abs(leftSum / (i + 1) -
                    (nums.length - i == 1 ? 0 : rightSum / (nums.length - i - 1)));

            if (diff < min){
                min = diff;
                res = i;
            }
        }
        return res;
    }
}
