import java.util.ArrayList;
import java.util.List;

public class Q113 {
    //path sum II
    // given the root of a binary tree and an integer targetSum,
    // return all root to leaf paths where the sum of the nodes values
    // in the path equals targetSum
    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes,
                             List<List<Integer>> paths){
        if (node == null) return;

        pathNodes.add(node.val);

        if (remainingSum == node.val && node.left == null && node.right == null){
            paths.add(new ArrayList<>(pathNodes));
        } else {
            recurseTree(node.left, remainingSum - node.val, pathNodes, paths);
            recurseTree(node.right, remainingSum - node.val, pathNodes, paths);
        }

        pathNodes.remove(pathNodes.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recurseTree(root, sum, path, result);
        return result;
    }
}
