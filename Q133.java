import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Q133 {
    /*
    133. Clone Graph
     */
    public Node cloneGraph(Node node){
        if (node == null) return node;

        HashMap<Node, Node> map = new HashMap<>();

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()){
            Node n = queue.remove();

            for (Node neighbor : n.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
