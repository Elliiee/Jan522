import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
    //serialize and deserialize binary tree
    public String serialize(TreeNode root){
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node == null){
                result.append("n ");
                continue;
            }

            result.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return result.toString();
    }

    public TreeNode deserialize(String data){
        if (data == "") return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++){
            TreeNode parent = queue.poll();
            if (!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
