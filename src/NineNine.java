import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-5-8
 */
public class NineNine {
	List<TreeNode> expNode;
	TreeNode expParent;
	TreeNode root;
	void findIndex(TreeNode root , TreeNode max , TreeNode min) {
		//check
		if ( root != max ) {

		}
		if ( root != min ) {

		}
		if ( root.left != null ) {
			findIndex(root.left,root,min);
		}
		if ( root.right != null ) {
			findIndex(root.right,max,root);
		}
	}
	public void recoverTree(TreeNode root) {

	}
}
