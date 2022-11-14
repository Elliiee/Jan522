import java.util.ArrayDeque;
import java.util.Deque;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        if (n == 0) return nums;
        int[] result = new int[n - k + 1];

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            // remove numbers out of range k
            // one round we only accept one element, so we pop at most one element
            if (!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }

            //remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            // q contains index, r contains content
            q.offer(i);
            if (i - k + 1 >= 0){
                result[i - k + 1] = nums[q.peek()];
            }
        }
        return result;
    }
}
