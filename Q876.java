public class Q876 {
    // middle of the linked list
    // find the middle of the linked list node
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 如果fast到了倒数第二个node，fast.next.next没有了，是null;
        // 还是要往后面走一次，因为slow还差一步到中间（奇数）/中间的第二个数（偶数）
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
