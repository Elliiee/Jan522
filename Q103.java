import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol; 
    }
    private void travel(TreeNode curr, List<List<Integer>> sol, int level){
        if (curr == null) return;

        if (sol.size() <= level){
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0)
            collection.add(curr.val);
        else
            collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrderII(TreeNode root){
        List<List<Integer>> listAnswer = new LinkedList<>();

        if (root == null){
            return listAnswer;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(even){
                    subList.add(current.val);
                } else {
                    subList.addFirst(current.val);
                }

                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            listAnswer.add(subList);
            even = !even;
        }

        return listAnswer;
    }
}
