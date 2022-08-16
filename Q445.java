import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;

public class Q445 {
    // add two numbers II
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            node.val = sum % 10;

            ListNode head = new ListNode(sum / 10);
            head.next = node;
            node = head;
            sum /= 10;
        }

        return node.val == 0 ? node.next : node;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        ListNode current;
        while (!s1.isEmpty() || !s2.isEmpty()){
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            current = new ListNode (sum % 10);
            current.next = head;
            head = current; // build result list backwards
            carry = sum / 10;
        }

        if (carry == 1){
            current = new ListNode(1);
            current.next = head;
            head = current;
        }

        return head;
    }
}
