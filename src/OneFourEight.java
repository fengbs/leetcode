/**
 * Created by lideqing@xiaomi.com on 20-4-22
 */
public class OneFourEight {
    ListNode partition(ListNode startNode, ListNode endNode) {
        if (startNode == null || startNode == endNode) {
            return startNode;
        }
        ListNode middle = startNode;
        ListNode i = startNode;
        ListNode j = startNode.next;
        while (j != endNode) {
            while (i.next != endNode && i.next.val <= middle.val) {
                i = i.next;
            }
            j = i.next;
            while (j != endNode) {
                if (j.val > middle.val) {
                    j = j.next;
                } else {
                    int tem = i.next.val;
                    i.next.val = j.val;
                    j.val = tem;
                    i = i.next;
                }
            }
        }
        int tem = middle.val;
        middle.val = i.val;
        i.val = tem;
        return i;
    }

    void doSort(ListNode startNode, ListNode endNode) {
        if (startNode == null || startNode == endNode) {
            return;
        }
        ListNode node = partition(startNode, endNode);
        doSort(startNode, node);
        doSort(node.next, endNode);
    }

    public ListNode sortList(ListNode head) {
        doSort(head, null);
        return head;
    }

    public static void main(String[] args) {
        OneFourEight oneFourEight = new OneFourEight();
        ListNode node = CommonUtil.LinkedListFromStr("5,2,1,3,4,6,7");
        CommonUtil.printLinkedList(oneFourEight.sortList(node));
    }
}
