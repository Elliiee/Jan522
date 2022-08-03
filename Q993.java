import java.util.LinkedList;
import java.util.Queue;

public class Q993 {
    // cousins in binary tree
    public boolean isCousins(TreeNode root, int x, int y){
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();

            boolean isAExist = false;
            boolean isBExist = false;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (node.val == x)
                    isAExist = true;
                if (node.val == y)
                    isBExist = true;

                if (node.left != null && node.right != null){
                    if (node.left.val == x && node.right.val == y)
                        return false; // sibling not cousin
                    if (node.left.val == y && node.right.val == x)
                        return false; // sibling not cousin
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (isAExist && isBExist)
                return true;
            if (isAExist || isBExist)
                return false;
        }
        return false;
    }
}
