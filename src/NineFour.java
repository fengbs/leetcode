import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-20
 */
public class NineFour {
    List<Integer> res = new ArrayList<>();
    private void dfs( TreeNode root ) {
        if ( root.left != null ) {
            dfs(root.left);
        }
        res.add(root.val);
        if ( root.right != null ) {
            dfs(root.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {

        if ( root == null ) {
            return res;
        }
        dfs(root);
        return res;

    }

    public static void main ( String []args) {
        NineFour nineFour = new NineFour();
        TreeNode treeNode = CommonUtil.toTree("1");
        CommonUtil.printList(nineFour.inorderTraversal(treeNode));
    }
}
