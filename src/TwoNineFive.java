import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class TwoNineFive {
    /**
     * initialize your data structure here.
     */
    class MedianFinder {
        PriorityQueue<Integer> priorityQueue1 = null;
        PriorityQueue<Integer> priorityQueue2 = null;
        int count = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            priorityQueue1 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }

        public void addNum(int num) {
            count++;
            if (count % 2 == 0) {
                if (priorityQueue1.peek() > num) {
                    int tem = priorityQueue1.poll();
                    priorityQueue1.add(num);
                    priorityQueue2.add(tem);
                } else {
                    priorityQueue2.add(num);
                }
            } else {
                if (priorityQueue2.size() > 0 && priorityQueue2.peek() < num) {
                    int tem = priorityQueue2.poll();
                    priorityQueue1.add(tem);
                    priorityQueue2.add(num);
                } else {
                    priorityQueue1.add(num);
                }
            }

        }

        public double findMedian() {
            if (count % 2 == 0) {
                return 1.0D * (priorityQueue1.peek() + priorityQueue2.peek()) / 2;
            } else {
                return priorityQueue1.peek();
            }
        }

    }

    public static void main(String[] args) {
        TwoNineFive twoNineFive = new TwoNineFive();
        TwoNineFive.MedianFinder medianFinder = twoNineFive.new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());

    }
}
