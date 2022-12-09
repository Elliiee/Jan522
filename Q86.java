public class Q86 {
    /*
    86 Partition List
    Move all the nodes less than x to the left side of the list.
    If it's equal to x, you don't need to move. Only the ones less than x.
     */
    /*
    The elements lesser than x come before the elements greater or equal to x.
    In the solution, our main aim is to create these two linked lists and join them.
     */
    /*
    Approach 1 Two Pointer Approach
    1. Initialize two pointers before and after.
        In the implementation we have initialized these two with a dummy ListNode.
    2. Iterate the original linked list, using the head pointer.
    3. If the node's value pointed by head is lesser than x, the node should be
        part of the before list.
    4. Else, the node should be part of after list. So we move it to after list.
    5. Once we are done with all the nodes in the original linked list, we should
        have two lists before and after. The original list nodes are either part
        of before list or after list, depending on its value.
    6. Now, these two lists before and after can be combined to form the reformed
        list.

     */
    public ListNode partition(ListNode head, int x){
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);
        ListNode before = beforeDummy; //use as a pointer to loop through the first part
        ListNode after = afterDummy; //use as a pointer to loop through the second part

        while (head != null){
            if (head.val < x){
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next; // move to the next node
        }
        after.next = null; // last node

        before.next = afterDummy.next; // connect two parts together

        return beforeDummy.next;
    }
}
