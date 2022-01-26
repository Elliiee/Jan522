import java.util.Comparator;
import java.util.PriorityQueue;

/*
23 Merge K Sorted Lists
You are given an array of k linked-lists, each linked-lists is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it. 
 */
public class Q23 {
    class NodeComparator implements Comparator<ListNode> {
        @Override
        public  int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists){
        // use a priority queue,
        // pop the smallest out and push its next in
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.length == 0)
            return dummy.next;

        int size = lists.length;
        ListNode current = dummy;
        NodeComparator cmp = new NodeComparator();
        PriorityQueue<ListNode> pqueue = new PriorityQueue<>(cmp);
        for (int i = 0; i < size; i++){
            if (lists[i] != null)
                pqueue.add(lists[i]);
        }
        while (pqueue.size() != 0){
            ListNode node = pqueue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null)
                pqueue.add(node.next);
        }
        return dummy.next;
    }
}
