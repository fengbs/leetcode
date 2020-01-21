import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 19-11-25
 */

public class OneThreeThree {

    private Map<Node, Node> usedMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else {

            if (usedMap.containsKey(node)) {
                return usedMap.get(node);
            }
            List<Node> neighbors = node.neighbors;
            List<Node> newNeighbors = new LinkedList<>();
            Node newNode = new Node(node.val, newNeighbors);
            usedMap.put(node, newNode);
            if (neighbors != null) {
                for (Node neightbor : neighbors) {
                    Node newNeightbor = cloneGraph(neightbor);
                    newNeighbors.add(newNeightbor);
                }

            }

            return newNode;
        }
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main (String []args) {
        OneThreeThree oneThreeThree = new OneThreeThree();
        List<Node> p1 = new ArrayList<>();
        List<Node> p2 = new ArrayList<>();
        Node n1 = new Node(1,p1);
        Node n2 = new Node(2,p2);
        p1.add(n2);
        p2.add(n1);
        Node res = oneThreeThree.cloneGraph(n1);
        System.out.println("finish");
    }
}

