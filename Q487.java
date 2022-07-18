public class Q487 {
    // max consecutive ones II
    public int findMaxConsecutiveOnes(int[] nums){
        int longestSequence = 0;
        int left = 0, right = 0, numZeros = 0;

        while (right < nums.length){
            if (nums[right] == 0){
                numZeros++;
            }

            while (numZeros == 2){
                if (nums[left] == 0){
                    numZeros--;
                }
                left++;
            }

            longestSequence = Math.max(longestSequence, right - left + 1);

            right++;
        }

        return longestSequence;
    }
}
