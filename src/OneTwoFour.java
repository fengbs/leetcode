/**
 * Created by lideqing@xiaomi.com on 19-7-25
 */
public class OneTwoFour {
	int max = 0 ;
	public int maxPathSum( TreeNode root ) {
		if ( root == null ) {
			return max;
		}
		max = root.val;
		dfs(root);
		return max;
	}

	public int dfs( TreeNode root ) {
		int left = 0;
		int right = 0;
		int sum = root.val;
		if ( root.left != null ) {
			left = dfs(root.left);
		}
		if ( root.right != null ) {
			right = dfs(root.right);
		}
		sum += left>0?left:0;
		sum += right>0?right:0;
		if ( sum > max ) {
			max = sum;
		}
		int maxBranch = Math.max(left,right);
		return (maxBranch>0?maxBranch:0) + root.val;
	}

	public static void main ( String []args ) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		TreeNode root = CommonUtil.toTree("5,4,8,11,null,13,4,7,2,null,null,null,1,null,null,null,80");
		System.out.println(oneTwoFour.maxPathSum(root));

	}

}
