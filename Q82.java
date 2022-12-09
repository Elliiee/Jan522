public class Q82 {
    /*
    82 Remove duplicates from sorted list II
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers.
    Note here, it deletes all the duplicates including the original one, not just the
    copies which is harder to implement.
     */
    /*
    Approach 1 Sentinel Head + Predecessor
    What do we do if the head is going to be deleted?
    The standard way to handle this use case is to use the Sentinel Node.
    Although, the primary purpose is to standardize the situation to avoid edge case.

    The input list is sorted, and we can determine if a node is a duplicate by
    comparing its value to the node after it.

    Remember the first node in the duplicates list should be removed as well.
    So we have to keep track of the predecessor, in order to remove the original.


     */

    public ListNode deleteDuplicates(ListNode head){
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        //remember pointer starts from dummy because the head could be
        //duplicated too
        ListNode predecessor = sentinel;

        while (head != null){
            if (head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                predecessor.next = head.next; // delete all
            } else {
                predecessor = predecessor.next;
            }

            head = head.next;
        }
        return sentinel.next;
    }
}
