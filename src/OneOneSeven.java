import javafx.util.Pair;

/**
 * Created by lideqing@xiaomi.com on 19-12-6
 */
//TODO
public class OneOneSeven {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


    public Node connect(Node root) {
        /*if (root == null) {
            return null;
        }
        //左
        //Pair<Node,Node> left = doConnect(root.left);
        //右
        Pair<Node,Node> right = doConnect(root.right);
        if (left.getValue() != null) {
            left.getValue().next = right.getKey();
        }
        return root;
        */
        return null;
    }
}
