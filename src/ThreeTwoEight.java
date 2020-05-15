/**
 * Created by lideqing@xiaomi.com on 20-4-3
 */
public class ThreeTwoEight {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode firstEnd = head;
        ListNode second = head.next;
        ListNode secondEnd = second;
        ListNode index = null;
        if (second != null) {
            index = second.next;
        } else {
            return head;
        }
        while (index != null) {
            firstEnd.next = index;
            index = index.next;
            firstEnd = firstEnd.next;
            if (index != null) {
                secondEnd.next = index;
                secondEnd = secondEnd.next;
                index = index.next;
            }
        }
        firstEnd.next = second;
        secondEnd.next = null;
        return first;
    }

    public static void main(String[] args) {
        ThreeTwoEight threeTwoEight = new ThreeTwoEight();
        ListNode input = CommonUtil.LinkedListFromStr("1,2,3");
        CommonUtil.printLinkedList(threeTwoEight.oddEvenList(input));
    }
}
