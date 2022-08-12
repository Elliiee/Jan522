public class Q109 {
    //convert sorted list to binary search tree
    private ListNode findMiddleElement(ListNode head){
        ListNode pre = null, slow = head, fast = head;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) pre.next = null;// don't understand this line.

        return slow;
    }

    public TreeNode sortedListToBST(ListNode head){
        if (head == null) return null;

        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);

        if (head == mid) return node; // base case when there is just one element in the list.

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }
}
