import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-3-26
 */
public class NineThreeEight {
	public int rangeSumBST(TreeNode root, int L, int R) {
		LinkedList<TreeNode> nodeList = new LinkedList<>();
		if ( root == null ) {
			return 0;
		}
		int sum = 0;
		nodeList.add(root);
		while (nodeList.size() != 0) {
			TreeNode node = nodeList.pollLast();
			if ( node.val >= L && node.val <= R ) {
				sum += node.val;
				if ( node.left != null ) {
					nodeList.addFirst(node.left);
				}
				if ( node.right != null ) {
					nodeList.addFirst(node.right);
				}
			} else if ( node.val < L ) {
				if ( node.right != null ) {
					nodeList.addFirst(node.right);
				}
			} else {
				if (node.left != null) {
					nodeList.addFirst(node.left);
				}
			}
		}
		return sum;
	}
	public static void main ( String [] args ) {
		NineThreeEight nineThreeEight = new NineThreeEight();
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(18);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		System.out.println(nineThreeEight.rangeSumBST(n1,7,15));
	}

}
