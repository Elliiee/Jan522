import java.util.HashMap;
import java.util.Map;

public class Q560 {
    // sub-array sum equals k
    public int subarraySum(int[] nums, int k){
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // all seen presum
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (preSum.containsKey(sum - k))
                result += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
