import java.util.List;

public class Q431 {
    //encode n-ary tree to binary tree and decode back
    public TreeNode encode(Node root){
        if (root == null) return null;

        TreeNode result = new TreeNode(root.val);

        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
