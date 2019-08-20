import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-19
 */
public class OneNineNine {
    List<Integer> list = new LinkedList<>();
    public void doRightSideView(TreeNode root,int cell) {
        if ( cell == list.size() ) {
            list.add(root.val);
        }
        if ( root.right != null){
            doRightSideView(root.right,cell+1);
        }
        if ( root.left != null ) {
            doRightSideView(root.left, cell + 1);
        }

    }
    public List<Integer> rightSideView(TreeNode root) {
        if ( root == null ) {
            return list;
        }
        doRightSideView(root,0);
        return list;
    }


    public static void main ( String []args) {
        OneNineNine oneNineNine = new OneNineNine();
        TreeNode node = CommonUtil.toTree("1");
        List<Integer> list = oneNineNine.rightSideView(node);
        for ( Integer i : list ) {
            System.out.println(i);
        }
    }
}
