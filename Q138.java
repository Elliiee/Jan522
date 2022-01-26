import java.util.HashMap;

/*
138 Copy List with Random Pointer
shallow copy 用一个等号"=" copy 一下地址而已
deep copy 是重新建立一个自己的object

// 这题写起来并不复杂，关键是明白deep copy是什么意思
 */
public class Q138 {
    public Node copyRandomList(Node head){
        if (head == null)
            return head;

        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        // 先建立新的node
        while (current != null){
            map.put(current, new Node(current.val, null, null));
            current = current.next;
        }
        // 再链接next 和random的值
        current = head;
        while (current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head); // 注意这里是新的list的head
    }
}
