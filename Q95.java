import java.util.LinkedList;
import java.util.List;

public class Q95 {
    //unique binary search trees II
    public List<TreeNode> generateTrees(int n){
        if (n == 0)
            return new LinkedList<TreeNode>();

        return generate(1, n);
    }

    private LinkedList<TreeNode> generate(int start, int end){
        LinkedList<TreeNode> results = new LinkedList<>();

        if (start > end){
            results.add(null);
            return results;
        }

        for (int i = start; i <= end; i++){
            LinkedList<TreeNode> left = generate(start, i - 1);
            LinkedList<TreeNode> right = generate(i + 1, end);

            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    results.add(current);
                }
            }
        }

        return results;
    }
}
