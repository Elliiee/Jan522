public class Q2095 {
    // delete the middle node of a linked list
    public ListNode deleteMiddle(ListNode head){
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
