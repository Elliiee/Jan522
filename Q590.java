import java.util.LinkedList;
import java.util.List;

public class Q590 {
    public List<Integer> postorder(NodeNary root) {
        LinkedList<Integer> answer = new LinkedList<>();
        if (root == null)
            return answer;
        LinkedList<NodeNary> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()){
            NodeNary node = stack.pollLast();
            answer.addFirst(node.val); // very important
            for (NodeNary item : node.children){
                stack.add(item);
            }
        }
        return answer;
    }
}
