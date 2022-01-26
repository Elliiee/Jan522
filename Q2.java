/*
2 Add two numbers
You are given two non-empty linked lists representing two non-negative integers. The
digits are stored in reverse order, and each of their nodes contains a single digit. Add
the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Q2 {
    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            int lastDigit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(lastDigit);
            current.next = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            current = current.next;
        }

        if (carry > 0){
            ListNode newNode = new ListNode(1);
            current.next = newNode;
            current = current.next;
        }

        return dummyHead.next;
    }
}
