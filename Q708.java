public class Q708 {
    /*
    708. insert into a cyclic sorted list
     */
    public Node insert(Node head, int insertVal){
        if (head == null){
            //if the linked list is empty, just create the node
            //but remember to make it single node as a cycle
            Node newNode = new Node(insertVal);
            newNode.next = newNode; //make it as a cycle
            return newNode;
        }

        //two pointers to be able to access both previous and current node
        //so when you find the place you insert it in between the two nodes
        Node prev = head;
        Node current = head.next;
        boolean toInsert = false;

        do{
            if (prev.val <= insertVal && insertVal <= current.val){
                //case 1 the insert value is in between the min and max
                toInsert = true; // insert it
            } else if (prev.val > current.val){
                //the insert value goes beyond the min and max value of the cycle
                //case 2
                if (insertVal >= prev.val || insertVal <= current.val){
                    toInsert = true;
                }

                if (toInsert){
                    prev.next = new Node(insertVal, current);
                    return head;
                }

                prev = current;
                current = current.next;
            }
        }while (prev != head); //if prev is head again, means the end of the cycle.

        //case 3 all the cycle linked list values are the same one
        // you can insert in any place, it's a cycle, so it will be sorted anyway
        prev.next = new Node(insertVal, current);
        return head;
    }
}
