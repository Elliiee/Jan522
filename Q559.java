import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q559 {
    public int maxDepth(NodeNary root) {
        if (root == null)
            return 0;
        if (root.children.isEmpty())
            return 1;
        List<Integer> heights = new LinkedList<>();
        for (NodeNary item : root.children){
            heights.add(maxDepth(item));
        }
        return Collections.max(heights) + 1;
    }
}
