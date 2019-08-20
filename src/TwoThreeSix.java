import javax.transaction.TransactionRequiredException;

/**
 * Created by lideqing@xiaomi.com on 19-4-1
 */
public class TwoThreeSix {
	private TreeNode res = null;

	private int dfs(TreeNode node,TreeNode p,TreeNode q) {

		if (node == null) {
			return 0;
		}
		TreeNode resNode = null;
		int current = 0 ;
		int leftRes = dfs(node.left,p,q);
		int rightRes = dfs(node.right,p,q);
		if ( p == node ) {
			current += 1;
		}
		if ( q == node ) {
			current +=2;
		}
		if ( leftRes + rightRes + current == 3 ) {
			res = node;
			return 0;
		}
		return leftRes + rightRes + current;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root,p,q);
		return res;
	}

	public static void main ( String []args ) {
	}
}
