/**
 * Created by lideqing@xiaomi.com on 19-8-20
 */
public class NineEight {
    private boolean isValidBST(TreeNode treeNode,long max ,int min) {
        if ( treeNode == null ) {
            return true;
        }
        if ( treeNode.val > max || treeNode.val < min ) {
            return false;
        }
        return isValidBST(treeNode.left,treeNode.val,min) && isValidBST(treeNode.right,max,treeNode.val);
    }
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) {
            return true;
        }
        return isValidBST(root, Integer.MAX_VALUE+1L ,Integer.MIN_VALUE);
    }

    public static void main ( String []args ) {
        NineEight nineEight = new NineEight();
        TreeNode res = CommonUtil.toTree(String.valueOf(Integer.MAX_VALUE));
        System.out.println(nineEight.isValidBST(res));
    }
}
