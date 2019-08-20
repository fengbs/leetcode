/**
 * Created by lideqing@xiaomi.com on 19-5-22
 */
public class QuickSortUsingLinkedList {

	public void doQuickSort(ListNode node , ListNode end) {
		ListNode middle = oneSort(node,end);
		oneSort(node,middle);
		oneSort(middle.next,end);

	}
	public void quickSort( ListNode header ) {
		if ( header == null ) {
			return ;
		}
		doQuickSort(header,null);
	}

	public ListNode oneSort(ListNode node , ListNode end) {
		ListNode highNode = node.next;
		ListNode lowNode = node;
		while ( highNode != end ) {
			if ( highNode.val < node.val ) {
				int temp = highNode.val;
				highNode.val = lowNode.next.val;
				lowNode.next.val = temp;
				lowNode = lowNode.next;
			}
			highNode= highNode.next;
		}
		int tem = node.val;
		node.val = lowNode.val;
		lowNode.val = tem;
		return lowNode;
	}

	public static void main ( String []args ) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		QuickSortUsingLinkedList quickSortUsingLinkedList = new QuickSortUsingLinkedList();
		quickSortUsingLinkedList.quickSort(n1);
		while ( n1 != null ) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
}
