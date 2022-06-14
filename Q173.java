import java.util.ArrayList;

public class Q173 {
    ArrayList<Integer> nodesSorted;
    int index;

    public Q173(TreeNode root){
        nodesSorted = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root){
        if (root == null)
            return;

        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }

    public int next(){
        return nodesSorted.get(++index);
    }

    public boolean hasNext(){
        return index + 1 < nodesSorted.size();
    }
}
