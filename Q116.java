import java.util.LinkedList;
import java.util.Queue;

public class Q116 {
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

    public Node connect(Node root){
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();

                if (i < size - 1)
                    node.next = queue.peek();

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    public Node connectII(Node root){
        if (root == null)
            return null;

        Node leftmost = root;

        while (leftmost.left != null){
            Node head = leftmost;
            while (head != null){
                // link to the next node with the same parent
                head.left.next = head.right;

                // link to the next node with different parent
                if (head.next != null)
                    head.right.next = head.next.left;

                head = head.next; // it was connected at the previous level
            }
            // move to the next level
            leftmost = leftmost.left;
        }
        return root;
    }
}
