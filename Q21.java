/*
21 Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together
the nodes of the first two lists.
Return the head of the merged linked list.
 */
public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
