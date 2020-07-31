import java.util.Random;

/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class ThreeEightTwo {
    private ListNode head = null;
    private Random random = null;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public ThreeEightTwo(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        if (head == null) {
            return 0;
        }
        int res = head.val;
        int i = 1;
        ListNode next = head.next;
        while (next != null) {
            int rand = random.nextInt(i + 1);
            if (rand < 1) {
                res = next.val;
            }
            next = next.next;
            ++i;
        }
        return res;
    }
}
