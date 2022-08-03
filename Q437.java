import java.util.HashMap;
import java.util.Map;

public class Q437 {
    private int findPathSum(TreeNode current, int sum, int target, Map<Integer, Integer> map){
        if (current == null) return 0;

        sum += current.val;

        int numPathToCurr = map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int result = numPathToCurr + findPathSum(current.left, sum, target, map)
                + findPathSum(current.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);

        return result;
    }

    public int pathSum(TreeNode root, int targetSum){
        if (root == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return findPathSum(root, 0, targetSum, map);
    }
}
