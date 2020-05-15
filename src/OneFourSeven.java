/**
 * Created by lideqing@xiaomi.com on 20-3-23
 */
public class OneFourSeven {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode index = head;
        ListNode sortEnd = newHead;
        while (index != null) {
            if (sortEnd != newHead && index.val < sortEnd.val) {
                ListNode pre = newHead;
                while (pre.next.val < index.val) {
                    pre = pre.next;
                }
                ListNode tem = index;
                index = index.next;
                tem.next = pre.next;
                pre.next = tem;
                sortEnd.next = index;
            } else {
                sortEnd = index;
                index = index.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        OneFourSeven oneFourSeven = new OneFourSeven();
        ListNode input = CommonUtil.LinkedListFromStr("12");
        ListNode list = oneFourSeven.insertionSortList(input);
        CommonUtil.printLinkedList(list);
    }
}
