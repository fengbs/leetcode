
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-9-27
 */
public class OneOneFour {
    public void flatten(TreeNode root) {
        if ( root == null ) {
            return ;
        }
        doFlatten(root);
    }
    public TreeNode[] doFlatten(TreeNode root) {
        TreeNode[] pair = {root,root};
        TreeNode left = root.left;
        TreeNode right = root.right;
        if ( left != null ) {
            TreeNode[] temPair = doFlatten(left);
            pair[1].right = temPair[0];
            pair[1] = temPair[1];
        }
        if ( right != null ) {
            TreeNode[] temPair = doFlatten(right);
            pair[1].right = temPair[0];
            pair[1] = temPair[1];
        }
        pair[0].left = null;
        return pair;
    }

    public static void main(String []args) {
        OneOneFour oneOneFour = new OneOneFour();
        TreeNode treeNode = CommonUtil.toTree("1");
        oneOneFour.flatten(treeNode);
        System.out.println(treeNode);
    }
}
