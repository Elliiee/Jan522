import java.util.Arrays;

public class Q977 {
    public int[] sortedSquares(int[] nums){
        int N = nums.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans); // time is logN
        return ans;
    }

    public int[] sortedSqauresII(int[] nums){
        int N = nums.length;
        int[] ans = new int[N];
        int left = 0, right = N -1;

        for (int i = N - 1; i >= 0; i--){
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            ans[i] = square * square;
        }
        return ans;
    }
}
