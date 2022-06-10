public class Q117 {
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right, Node _next){
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Node prev_nextLevel, leftmost;

    public void processChild(Node Node){
        if (Node != null){
            if (prev_nextLevel != null){
                prev_nextLevel.next = Node;
            } else {
                leftmost = Node;
            }
            prev_nextLevel = Node;
        }
    }

    public Node connect(Node root){
        if (root == null)
            return null;

        leftmost = root;

        Node current = leftmost;

        while (leftmost != null){
            prev_nextLevel = null;
            current = leftmost;
            leftmost = null;
            while (current != null){
                processChild(current.left);
                processChild(current.right);
                current = current.next;
            }
        }
        return root;
    }
}
