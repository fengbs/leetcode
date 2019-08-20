
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class SevenZeroZero {
	public TreeNode searchBST(TreeNode root, int val) {
		if ( root != null ) {
			 if ( root.val == val ) {
			 	return root;
			 } else if (root.val > val) {
			 	return searchBST(root.left, val);
			 } else {
				return searchBST(root.right,val);
			 }
		}
		return null;
	}

	public static void main ( String []args ) {
		SevenZeroZero sevenZeroZero = new SevenZeroZero();
		TreeNode treeNode1 = new TreeNode(18);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(22);
		TreeNode treeNode4 = new TreeNode(63);
		TreeNode treeNode5 = new TreeNode(84);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode3.right = treeNode4;
		treeNode4.right = treeNode5;
		TreeNode res = sevenZeroZero.searchBST(treeNode1,63);
		System.out.println(res==null?0:res.val);
	}
}
