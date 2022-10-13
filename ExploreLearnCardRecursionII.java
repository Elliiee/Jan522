import java.util.LinkedList;
import java.util.List;

public class ExploreLearnCardRecursionII {
    /*
    95, unique binary search trees II
     */
    public LinkedList<TreeNode> generate_trees(int start, int end){
        LinkedList<TreeNode> all_trees = new LinkedList<>();

        if (start > end){
            all_trees.add(null);
            return all_trees;
        }

        for (int i = start; i <= end; i++){ // pick root number
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // then connect left tree and right tree to the root i
            for (TreeNode left : left_trees){
                for (TreeNode right : right_trees){
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = left;
                    current_tree.right = right;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n){
        if (n == 0) return new LinkedList<TreeNode>();

        return generate_trees(1, n);
    }
}
