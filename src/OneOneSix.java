import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-9-29
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class OneOneSix {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> source = new LinkedList<>();
        LinkedList<Node> res = new LinkedList<>();
        source.add(root);
        while (source.size() != 0) {
            Node firstNode = source.pollFirst();
            while(source.size() != 0) {
                if ( firstNode.left != null ) {
                    res.add(firstNode.left);
                }
                if ( firstNode.right != null ) {
                    res.add(firstNode.right);
                }
                Node secondNode = source.pollFirst();
                firstNode.next = secondNode;
                firstNode = secondNode;
            }
            LinkedList tem = source;
            source = res;
            res = tem;
        }
        return root;
    }
}
