import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-4-1
 */

public class NineFive {
	private List<TreeNode> dfs ( int start,int end ) {
		if (start > end ) {
			List<TreeNode> list = new ArrayList<>();
			list.add(null);
			return list;
		}
		if ( start == end ) {
			TreeNode treeNode = new TreeNode(start);
			List<TreeNode> list = new ArrayList<>();
			list.add(treeNode);
			return list;
		}
		List<TreeNode> res = new ArrayList<>();
		for ( int i = start ; i <= end ; ++i ) {
			List<TreeNode> leftNode = dfs(start,i-1);
			List<TreeNode> rightNode = dfs(i+1,end);
			for (TreeNode treeNode : leftNode ) {
				for (TreeNode treeNode1 : rightNode) {
					TreeNode root = new TreeNode(i);
					root.left = treeNode;
					root.right = treeNode1;
					res.add(root);
				}
			}
		}
		return res;
	}
	public List<TreeNode> generateTrees(int n) {
		if ( n ==0 ) {
			return new ArrayList<>();
		}
		return dfs(1,n);
	}

	public static void main ( String []args ) {
		NineFive nineFive = new NineFive();
		List<TreeNode> list = nineFive.generateTrees(3);
		System.out.println(list);
	}

}
