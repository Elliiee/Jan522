import java.util.ArrayList;
import java.util.List;

public class Q501 {
    //find mode in binary search tree
    private int currentCount = 1, maxCount = 1; // question gives at least 1 node constraints
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        int[] ret = new int[result.size()];
        int index = 0;
        for (int n : result){
            ret[index++] = n;
        }
        return ret;
    }

    private void inorder(TreeNode node, List<Integer> nums){
        if (node == null) return;

        inorder(node.left, nums);

        if (preNode != null){
            if (preNode.val == node.val) currentCount++;
            else currentCount = 1;
        }
        if (currentCount > maxCount){
            maxCount = currentCount;
            nums.clear();
            nums.add(node.val);
        } else if (currentCount == maxCount){
            nums.add(node.val);
        }
        preNode = node;

        inorder(node.right, nums);
    }
}
