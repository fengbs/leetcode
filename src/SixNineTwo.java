import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-6-12
 */
public class SixNineTwo {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> list = new LinkedList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        Map<String, Integer> mp = new HashMap<>();
        for (String str : words) {
            if (mp.get(str) == null) {
                mp.put(str, 1);
            } else {
                mp.put(str, mp.get(str) + 1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        for(Map.Entry<String,Integer> entry : mp.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else {
                if (priorityQueue.peek().getValue() < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                } else if(priorityQueue.peek().getValue() == entry.getValue() && priorityQueue.peek().getKey().compareTo(entry.getKey()) > 0){
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                }
            }
        }
        while (priorityQueue.size() > 0) {
            Map.Entry<String,Integer> entry = priorityQueue.poll();
            list.addFirst(entry.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        SixNineTwo sixNineTwo = new SixNineTwo();
        String []input = {"i","love", "leetcode", "i", "love", "coding", "coding", "coding"};
        System.out.println(sixNineTwo.topKFrequent(input,2));
    }
}
