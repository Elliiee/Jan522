public class Q747 {
    // largest number at least twice of others
    public int dominantIndex(int[] nums) {
        int N = nums.length;
        int max = 0, maxIndex = -1;
        for (int i = 0; i < N; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int j = 0; j < N; j++){
            if ((nums[j] != max) &&  (max < 2 * nums[j])){
                return -1;
            }
        }
        return maxIndex;
    }
}
