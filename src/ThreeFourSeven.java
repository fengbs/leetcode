import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-3-31
 */
public class ThreeFourSeven {
    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue;

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k == 0) {
            return new LinkedList<>();
        }
        priorityQueue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(mp);
            } else {
                if (priorityQueue.peek().getValue() < mp.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(mp);
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> mp : priorityQueue) {
            res.add(mp.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeFourSeven threeFourSeven = new ThreeFourSeven();
        int[] input = {1, 1, 1, 2, 2, 3};
        CommonUtil.printList(threeFourSeven.topKFrequent(input, 2));
    }
}
