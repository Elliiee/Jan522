/*
206 Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class Q206 {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        return prev;
    }

    public ListNode reverseListRecursion(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode p = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
