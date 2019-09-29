import com.sun.deploy.util.StringUtils;
import java.util.LinkedList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by lideqing@xiaomi.com on 19-7-25
 */
public class CommonUtil {
	public static TreeNode toTree(String input) {
		if (input == null || input.equals("")) {
			return null;
		}
		String []str = input.split(",");
		if ( str ==null || str.length == 0 || str[0].equals("null") ) {
			return null;
		}
		int i = 1 ;
		LinkedList<TreeNode> list = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		list.addLast(root);
		while ( i < str.length ) {

			TreeNode parent = list.pollFirst();
			if ( parent == null ) {
				i+=2;
				list.addLast(null);
				list.addLast(null);
				continue;
			}
			TreeNode leftNode = null;
			if ( !str[i].equals("null") ) {
				leftNode = new TreeNode(Integer.parseInt(str[i]));
				parent.left = leftNode;

			}
			list.addLast(leftNode);
			++i;

			TreeNode rightNode = null;
			if ( i < str.length && !str[i].equals("null") ) {
				rightNode = new TreeNode(Integer.parseInt(str[i]));
				parent.right = rightNode;
			}
			list.addLast(rightNode);
			++i;
		}
		return root;
	}

	public static <T> void printList2( List<List<T>> list) {
		for ( List<T> temList : list ) {
			for ( T obj : temList ) {
				System.out.print(obj.toString() + " ");
			}
			System.out.println();
		}
	}

	public static <T> void printList( List<T> list) {
			for ( T obj : list ) {
				System.out.print(obj.toString() + " ");
			}
			System.out.println();
	}

	public static void printLinkedList(ListNode listNode) {
		while ( listNode != null ) {
			System.out.print(listNode.val+" ");
			listNode = listNode.next;
		}
	}

	public static ListNode LinkedListFromStr(String input) {
		String [] arr = input.split(",");
		if ( arr == null || arr.length == 0 ) {
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode pre = head;
		for ( String str : arr ) {
			pre.next = new ListNode(Integer.parseInt(str));
			pre = pre.next;
		}

		ListNode res = head.next;
		head.next = null;
		return res;
	}

}
