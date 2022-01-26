/*
160 Intersection of Two Linked Lists
Given the heads of two singly linked-lists headA and headB, return the node at which the
two lists intersect. If the two linked lists have no intersection at all, return null;
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null)
            return null;

        ListNode aPointer = headA;
        ListNode bPointer = headB;

        while (aPointer != bPointer){
            if (aPointer == null){
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }

            if (bPointer == null){
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }

        return aPointer;
    }
}
