import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q448 {
    // find all numbers disappeared in an array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }
        for (int i = 1; i <= nums.length; i++){
            if (!set.contains(i)){
                answer.add(i);
            }
        }
        return answer;
    }
}
