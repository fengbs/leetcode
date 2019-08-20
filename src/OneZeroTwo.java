import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-19
 */
public class OneZeroTwo {
    List<List<Integer>> list  = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null ) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> temQueue = new LinkedList<>();
        temQueue.add(root);
        while ( temQueue.size() != 0 ) {
            LinkedList<TreeNode> tem = queue;
            queue = temQueue;
            temQueue = tem;
            List<Integer> resCell = new ArrayList<>();
            while (queue.size() != 0) {
                TreeNode treeNode = queue.pollLast();
                if ( treeNode.left != null ) {temQueue.addFirst(treeNode.left);}
                if ( treeNode.right != null ) {temQueue.addFirst(treeNode.right);}
                resCell.add(treeNode.val);
            }
            list.add(resCell);
        }
        return list;
    }

    public static void main ( String []args ) {
        OneZeroTwo oneZeroTwo = new OneZeroTwo();
        TreeNode input = CommonUtil.toTree("1,2,3,4,null,null,5");
        List<List<Integer>> res = oneZeroTwo.levelOrder(input);
        CommonUtil.printList2(res);
    }
}
