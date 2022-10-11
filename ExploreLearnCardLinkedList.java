import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExploreLearnCardLinkedList {
    /*
    Overview
    Introduction
    Design singly linked list
     */
    private Node head;

    public ExploreLearnCardLinkedList(){
        head = null;
    }

    private Node getNode(int index){
        Node current = head;
        for (int i = 0; i < index && current != null; i++){
            current = current.next;
        }
        return current;
    }

    private Node getTail(){
        Node current = head;
        while (current != null && current.next != null){
            current = current.next;
        }
        return current;
    }

    public int get(int index){
        Node current = getNode(index);
        return current == null ? -1: current.val;
    }

    public void addAtHead(int val){
        Node current = new Node(val);
        current.next = head;
        head = current;
        return;
    }

    public void addAtTail(int val){
        if (head == null){
            addAtHead(val);
            return;
        }
        Node prev = getTail();
        Node current = new Node(val);
        prev.next = current;
    }

    public void addAtIndex(int index, int val){
        if (index == 0){
            addAtHead(val);
            return;
        }

        Node prev = getNode(index - 1);

        if (prev == null) return;

        Node current = new Node(val);
        Node next = prev.next;
        current.next = next;
        prev.next = current;
    }

    public void deleteAtIndex(int index){
        Node current = getNode(index);

        if (current == null) return;

        Node next = current.next;

        if (index == 0){
            head = next; // modify head when deleting the first node
        } else {
            Node prev = getNode(index - 1);
            prev.next = next;
        }
    }



    /*
    Two Pointer Technique

     */

    /*
    141. Linked List Cycle
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    public boolean hasCycle(ListNode head){
        if (head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null){
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    /*
    142. Linked List Cycle II
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle,
    return null.
     */
    /*
    If we keep track of the nodes that we've seen already in a set. We can traverse the list and
    return the first duplicate node.
     */
    public ListNode detectCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (set.contains(node))
                return node;
            set.add(node);
            node = node.next;
        }
        return null;
    }


    /*
    160. Intersection of Two linked lists
    Given the heads of two singly linked lists headA and headB, return the node at which the two
    lists intersect. If the two linked lists have no intersection at all, return null.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB){
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA; // if there is no intersection, it will still go through both lists
        // at the end, nodeA is null anyways.
    }


    /*
    19. remove the nth node from the end of the linked list
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */
    public ListNode removeNthNodeFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }



    /*
    Classic Linked List Problems
     */

    /*
    206. Reverse Linked List
    Given the head of a singly linked list, reverse the list, and return the reversed list.
     */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev; // the new head
    }

    //get a dummy node, if you need to remove some node.
    // so you don't lose the head during the removing process.

    /*
    203. Remove Linked List Elements
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that
    has Node.val == val, and return the new head;
     */
    public ListNode removeElement(ListNode head, int val){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null){
            if (current.val == val){
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next; // move to the next one and check
        }
        return dummy.next;
    }


    /*
    328. Odd Even Linked List
    Given the head of a singly linked list, group all the nodes with odd indices together followed by
    the nodes with even indices,and return the recorded list.
     */
    public ListNode oddEvenList(ListNode head){
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // tricky part
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    /*
    234.Palindrome Linked List
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     */
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null){
            if (slow.val != fast.val)
                return false;

            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    /*
    21. Merge two sorted lists
    Return the head of the merged linked list.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /*
    2. Add two numbers
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null){
            int l1val = (l1 != null) ? l1.val : 0;
            int l2val = (l2 != null) ? l2.val : 0;
            int sum = l1val + l2val + carry;
            carry = sum / 10;
            int lastDigit = sum % 10;
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
        return dummy.next;
    }


    /*
    430. Flatten a multilevel doubly linked list

     */
    class DoubleLinkNode {
        public int val;
        public DoubleLinkNode prev;
        public DoubleLinkNode next;
        public DoubleLinkNode child;
    }
    public DoubleLinkNode flatten(DoubleLinkNode head){
        if (head == null)
            return null;

        DoubleLinkNode p = head; // pointer
        while (p != null){
            // case 1: no child
            if (p.child == null){
                p = p.next;
                continue;
            }

            // case 2: has child: find the tail of the child and link it to p.next
            DoubleLinkNode temp = p.child;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = p.next; // connect tail with p.next if it is not null

            if (p.next != null){
                p.next.prev = temp;
            }

            //connect p with p.child and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }


    /*
    708. Insert into a sorted circular linked list

     */


    /*
    138. Copy List with random pointer
     */
    class RandomPointerNode {
        int val;
        RandomPointerNode next;
        RandomPointerNode random;

        public RandomPointerNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public RandomPointerNode copyRandomList(RandomPointerNode head){
        if (head == null) return null;

        RandomPointerNode current = head;
        Map<RandomPointerNode, RandomPointerNode> map = new HashMap<>();

        while (current != null){
            map.put(current, new RandomPointerNode(current.val));
            current = current.next;
        }

        current = head;
        while (current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random  = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    /*
    61. Rotate List
    Given the head of a linked list, rotate the list to the right by k place
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j = i - k % i; j > 0; j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}
