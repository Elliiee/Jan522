public class Q235 {
    // lowest common ancestor of a binary search tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int pVal = p.val, qVal = q.val;
        TreeNode node = root;
        while (node != null){
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal){
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal){
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
