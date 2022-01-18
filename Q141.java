/*
141 Linked List Cycle
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached
again by continuously following the next pointer. Internally, pos is used
 */
public class Q141 {
    public boolean hasCycle(ListNode head){
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
