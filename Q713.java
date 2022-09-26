public class Q713 {
    //subarray product less than k
    // return the number of contiguous subarrays where the product of all the elements less than k
    public int numSubarrayProductLessThanK(int[] nums, int k){
        int ans = 0, left = 0, curr = 0;

        for (int right = 0; right < nums.length; right++){
            curr *= nums[right];
            while (left <= right && curr >= k){
                curr /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
