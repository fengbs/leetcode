/**
 * Created by lideqing@xiaomi.com on 19-8-26
 */
public class EightTwo {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preHead = newHead;
        ListNode cur = head;
        int curNum = 0;
        ListNode pre = newHead;
        while ( cur != null ) {
            if (pre != newHead && pre.val == cur.val) {
                ++curNum;
            } else {
                if ( curNum > 0 ) {
                    preHead.next = cur;
                    pre.next = null;
                    curNum = 0 ;
                } else {
                    preHead = pre;
                }

            }
            pre = cur;
            cur = cur.next;
        }
        if ( curNum > 0 ) {
            preHead.next = cur;
            pre.next = null;
        }
        return newHead.next;
    }

    public static void main ( String []args) {
        EightTwo eightTwo = new EightTwo();
        ListNode head = CommonUtil.LinkedListFromStr("1,1,2,2,3,3,3");
        ListNode res = eightTwo.deleteDuplicates(head);
        CommonUtil.printLinkedList(res);
    }
}
