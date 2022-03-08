/*
105 Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder
traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.
 */
public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return buildTreeHelper(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){
        if (pre_st > preorder.length || in_st > in_end)
            return null;

        TreeNode current = new TreeNode(preorder[pre_st]);

        int i = in_st;
        while (i <= in_end){
            if (inorder[i] == preorder[pre_st]) // 这中寻找的方法说明没有重复的节点值吧
                break;
            i++;
        }

        current.left = buildTreeHelper(preorder, inorder, pre_st + 1, in_st, i - 1);
        current.right = buildTreeHelper(preorder, inorder, pre_st + (i - in_st + 1), i + 1, in_end);
        // i - in_st + 1 是left tree的size
        
        return current;
    }
}
