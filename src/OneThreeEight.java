import java.util.HashMap;
import java.util.Map;

/**
 * Created by lideqing@xiaomi.com on 20-2-19
 */
public class OneThreeEight {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> mp = new HashMap<>();
        Node preHead = new Node(0);
        Node indexNode = head;
        Node newHead = preHead;
        while (indexNode != null) {
            Node node = new Node(indexNode.val);
            mp.put(indexNode,node);
            newHead.next = node;
            newHead = node;
            indexNode = indexNode.next;
        }
        newHead = preHead.next;
        indexNode = head;
        while (newHead!=null) {
            if (indexNode.random != null) {
                newHead.random = mp.get(indexNode.random);
            }
            newHead = newHead.next;
            indexNode = indexNode.next;
        }
        return preHead.next;
    }
}
