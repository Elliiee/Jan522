/*
148 Sort List
Given the head of a linked list, return the list after sorting it in
ascending order.
 */
public class Q148 {
    // merge sort
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            temp = slow; //at the beginning
            slow = slow.next;  // in the middle
            fast = fast.next.next; // at the end
        }

        temp.next = null;
        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        return merge(leftSide, rightSide);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode sortedTemp = new ListNode(0);
        ListNode current = sortedTemp;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null){
            current.next = l1;
            l1 = l1.next;
        }

        if (l2 != null){
            current.next = l2;
            l2 = l2.next;
        }
        return sortedTemp.next;
    }
}
