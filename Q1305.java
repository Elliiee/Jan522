import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Q1305 {
    // all elements in two binary search trees
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        List<Integer> result = new ArrayList<>();

        Stream.of(inorder(root1, new ArrayList<>()),
                inorder(root2, new ArrayList<>())).forEach(result::addAll);
        Collections.sort(result);

        return result;
    }
    private List<Integer> inorder(TreeNode root, List<Integer> result){
        if (root == null) return result;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);

        return result;
    }
}
