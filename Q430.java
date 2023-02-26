public class Q430 {
    public Node flatten(Node head){
        if (head == null) return null;

        Node current = head;
        while (current != null){
            // case 1 if no child, proceed.
            if (current.child == null){
                current = current.next;
                continue;
            }

            //case 2 it has children
            Node currentChild = current.child;
            //find the tail of the children
            while (currentChild.next != null){
                currentChild = currentChild.next;
            }
            //connect the last child's node with current.next;
            currentChild.next = current.next;
            //if the current's next is not null, you need it to its previous node
            if (current.next != null){
                current.next.prev = currentChild;
            }

            //connect current with current's first child node and remove current.child
            current.next = current.child; //link current to its child as next;
            current.child.prev = current; //connect the first child with current as prev
            current.child = null; //remove the child link
        }
        return head;
    }
}
