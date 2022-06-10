import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q589 {
    public List<Integer> preorder(NodeNary root){
        LinkedList<NodeNary> stack = new LinkedList<>();
        LinkedList<Integer> answer = new LinkedList<>();

        if (root == null)
            return answer;

        stack.add(root);
        while (!stack.isEmpty()){
            NodeNary node = stack.pollLast();
            answer.add(node.val);
            Collections.reverse(node.children);
            for (NodeNary item : node.children){
                stack.add(item);
            }
        }
        return answer;
    }
}
