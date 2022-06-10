import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q429 {
    public List<List<Integer>> levelOrder(NodeNary root){
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<NodeNary> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                NodeNary node = queue.poll();
                level.add(node.val);
                for(NodeNary item : node.children){
                    queue.add(item);
                }
            }
            answer.add(level);
        }
        return answer;
    }
}
