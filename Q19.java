/*
19 Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return
its head.
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead; // 是假的开头不是真的head
        ListNode slow = dummyHead;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
