import java.util.List;

public class Node {
    int val;
    Node next;
    Node random;
    public List<Node> neighbors;
    Node prev;
    Node child;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random){
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int _val, Node _next){
        val = _val;
        next = _next;
    }
}
