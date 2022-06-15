import java.util.LinkedList;

public class Q450 {
    // Delete Node in BST

    // inorder traversal
    public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr){
        if (root == null)
            return arr;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

        return arr;
    }

    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }

    private int predecessor(TreeNode root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;

        if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null){
                root = null;
            } else if (root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else { // no right child, only left child here
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
