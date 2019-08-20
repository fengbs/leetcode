import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-19
 */
public class OneZeroThree {
    List<List<Integer>> list  = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if ( root == null ) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> temQueue = new LinkedList<>();
        temQueue.add(root);
        boolean leftFlag = true;
        while ( temQueue.size() != 0 ) {
            LinkedList<TreeNode> tem = queue;
            queue = temQueue;
            temQueue = tem;
            List<Integer> resCell = new ArrayList<>();
            while (queue.size() != 0) {
                TreeNode treeNode = null;
                if ( leftFlag ) {
                    treeNode = queue.pollFirst();
                    if (treeNode.left != null) {
                        temQueue.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        temQueue.addLast(treeNode.right);
                    }
                } else {
                    treeNode = queue.pollLast();
                    if (treeNode.right != null) {
                        temQueue.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        temQueue.addFirst(treeNode.left);
                    }

                }

                resCell.add(treeNode.val);
            }
            leftFlag = leftFlag?false:true;
            list.add(resCell);
        }
        return list;
    }

    public static void main ( String []args ) {
        OneZeroThree oneZeroTwo = new OneZeroThree();
        TreeNode input = CommonUtil.toTree("1,2,3,4,null,null,5");
        List<List<Integer>> res = oneZeroTwo.zigzagLevelOrder(input);
        CommonUtil.printList2(res);
    }
}
