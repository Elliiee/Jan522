import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q863 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        List<Integer> res = new ArrayList<>();
        find(root, target);
        dfs(root, target, k, map.get(root), res);
        return res;
    }

    private int find(TreeNode root, TreeNode target){
        // find the target node
        // and also put all the "root to node distance" for the paths' nodes
        if (root == null) return -1;
        if (root == target){
            map.put(root, 0);
            return 0;
        }

        int left = find(root.left, target);
        if (left >= 0){
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0){
            map.put(root, right + 1);
            return right + 1;
        }

        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int k, int length, List<Integer> res){
        if (root == null) return;

        if (map.containsKey(root))
            length = map.get(root);

        if (length == k)
            res.add(root.val);

        dfs(root.left, target, k, length + 1, res);
        dfs(root.right, target, k, length + 1, res);
    }
}
