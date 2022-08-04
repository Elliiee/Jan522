import java.util.*;

public class Q314 {
    // binary tree vertical level order traversal
    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> columns = new ArrayDeque<>();
        queue.add(root);
        columns.add(0);
        int min = 0, max = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = columns.poll();

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null){
                queue.add(node.left);
                columns.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null){
                queue.add(node.right);
                columns.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++){
            result.add(map.get(i));
        }

        return result;
    }
}
