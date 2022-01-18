/*
234 Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome.
 */
public class Q234 {
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Q206 q206 = new Q206();
        slow = q206.reverseList(slow);
        fast = head;

        while (slow != null){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
