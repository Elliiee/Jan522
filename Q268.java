public class Q268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int fullSum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            fullSum += i+1;
        }
        return fullSum - sum;
    }
}
