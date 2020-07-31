/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class NineTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode tem = head;
        newHead.next = head;
        ListNode preHead = newHead;
        ListNode tail = newHead;
        int i = 1;
        while (tem!=null) {
            if (i==m ){
                preHead = tem;
                tem = tem.next;
                preHead.next = null;
            } else if ( i>m && i<=n) {
                ListNode pre = tem;
                tem = tem.next;
                pre.next = tail.next;
                tail.next = pre;
            } else if (i < m){
                tem = tem.next;
                tail = tail.next;
            } else {
                preHead.next = tem;
                break;
            }
            ++i;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        NineTwo nineTwo = new NineTwo();
        ListNode input = CommonUtil.LinkedListFromStr("1,2,3,4,5");
        CommonUtil.printLinkedList(nineTwo.reverseBetween(input,1,5));
    }
}
