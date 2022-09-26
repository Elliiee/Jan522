public class Q2270 {
    //number of ways to split array
    public int waysToSplitArray(int[] nums){
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            long leftHalf = prefix[i];
            long rightHalf = prefix[nums.length - 1] - prefix[i];
            if (leftHalf >= rightHalf)
                ans++;
        }

        return ans;
    }
}
