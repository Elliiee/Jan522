public class Q24 {
    public ListNode swapParis(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapParis(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
