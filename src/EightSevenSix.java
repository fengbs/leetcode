/**
 * Created by lideqing@xiaomi.com on 19-3-20
 */

public class EightSevenSix {
	static {
		System.out.println("heheh");
	}
	public static void main ( String []args ) {
		Solution solution = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		//node4.next = node5;
		//node5.next = node6;

		System.out.println(solution.middleNode(node1).val);
	}

	static class Solution {
		public ListNode middleNode(ListNode head) {
			int i = 0 ;
			ListNode temp = head;
			ListNode middle = head;
			while ( temp != null ) {
				++i;
				temp = temp.next;
				if (i%2 == 0) {
					middle = middle.next;
				}
			}
			return middle;
		}
	}
}


