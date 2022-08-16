import java.util.LinkedList;

public class Q725 {
    //split linked list in paris
    public ListNode[] splitListToParts(ListNode root, int k){
        ListNode[] parts = new ListNode[k];

        int length = 0;
        for (ListNode node = root; node != null; node = node.next)
            length++;

        int n = length / k, r = length % k;
        // n : minimum guaranteed part size, remain: extra nodes spread to the first r parts;
        ListNode prev = null, current = root;
        for (int i = 0; current != null && i < k; i++, r--){
            parts[i] = current;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++){
                prev = current;
                current = current.next;
            }
            prev.next = null;
        }
        return parts;
    }
}
