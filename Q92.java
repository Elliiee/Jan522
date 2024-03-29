public class Q92 {
    //reverse linked list II
    // given the head of a singly linked list and two integers left and right,
    // where left <= right, reverse the nodes of the list position to to position
    // right, and return the reversed list
    public ListNode reverseBetween(ListNode head, int left, int right){
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++){
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
