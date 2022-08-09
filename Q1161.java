import java.util.ArrayDeque;
import java.util.Queue;

public class Q1161 {
    //maximum level sum of a binary tree
    // the level of the root is 1; return the smallest level x which sum is the max.
    public int maxLevelSum(TreeNode root){
        int max = Integer.MIN_VALUE;
        int maxLevel = 1, level = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            if (sum > max){
                max = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}
