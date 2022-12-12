public class Q143 {
    /*
    143. Reorder List
    You are given the head of a singly linked list. The list can be represented as:
    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes.
    Only nodes themselves may be changed.
     */

    public void reorderList(ListNode head){
        //find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second part
        ListNode prev = null, current = slow;
        while (current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        //merge the 2 parts
        ListNode first = head, second = prev;
        while (second.next != null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
