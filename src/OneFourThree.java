/**
 * Created by lideqing@xiaomi.com on 20-3-23
 */
public class OneFourThree {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = head;
        ListNode before = head.next;
        ListNode after = slow.next;
        slow.next = null;
        if (after!=null) {
            ListNode afterHead = new ListNode(1);
            while (after!=null) {
                ListNode tem = afterHead.next;
                afterHead.next = after;
                after = after.next;
                afterHead.next.next = tem;
            }
            after = afterHead.next;
        }

        while (after != null) {
            ListNode tem;
            newHead.next = after;
            tem = after;
            after = after.next;
            tem.next = null;
            newHead = newHead.next;
            if (before != null) {
                newHead.next = before;
                tem = before;
                before = before.next;
                tem.next = null;
                newHead = newHead.next;
            }
        }

    }

    public static void main(String[] args) {
        OneFourThree oneFourThree = new OneFourThree();
        ListNode node = CommonUtil.LinkedListFromStr("1,2,3,4,5,6,7");
        oneFourThree.reorderList(node);
        CommonUtil.printLinkedList(node);
    }
}
