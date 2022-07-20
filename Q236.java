import java.util.*;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();

            // save the parent nodes
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null){ // all ancestors for p
            ancestors.add(p);
            p = parent.get(p);
        }

        // the first ancestor of q which appears in p's ancestor set()
        // is their lowest common ancestor
        while (!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }
}
