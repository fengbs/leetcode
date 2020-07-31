import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 20-7-16
 */
public class SevenThreeFive {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (Integer i : asteroids) {
            if (linkedList.size() == 0) {
                linkedList.addLast(i);
            } else {
                if (i < 0) {
                    while (linkedList.size()>0&&linkedList.getLast()>0&&Math.abs(i)>linkedList.getLast()) {
                        linkedList.pollLast();
                    }
                    if (linkedList.size() == 0 || linkedList.getLast()<0) {
                        linkedList.addLast(i);
                    }
                    if (linkedList.size()!=0 && linkedList.getLast() == -1*i) {
                        linkedList.pollLast();
                    }
                } else {
                    linkedList.addLast(i);
                }
            }
        }
        int []res = new int[linkedList.size()];
        int i = 0;
        while (linkedList.size()>0) {
            res[i] = linkedList.pollFirst();
            ++i;
        }
        return res;
    }

    public static void main(String[] args) {
        SevenThreeFive sevenThreeFive = new SevenThreeFive();
        int a[] = {10, 2, -5};
        CommonUtil.printIntArr(sevenThreeFive.asteroidCollision(a));
    }
}
