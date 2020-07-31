import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-5-29
 */
public class ThreeEightOne {
    public static class RandomizedCollection {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            list.add(val);
            map.putIfAbsent(val, new HashSet<>());
            Set<Integer> set = map.get(val);
            set.add(list.size() - 1);
            if (set.size() == 1) {
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            Set<Integer> set = map.get(val);
            if (map.get(val) == null || map.get(val).size() == 0) {
                return false;
            }
            int it = set.iterator().next();
            set.remove(it);
            if (it != list.size() - 1 ) {
                list.set(it, list.get(list.size() - 1));
                map.get(list.get(it)).remove(list.size() - 1);
                map.get(list.get(it)).add(it);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int length = list.size();
            Random rand = new Random();
            int index = Math.abs(rand.nextInt()) % length;
            return list.get(index);
        }
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(4);
        randomizedCollection.insert(3);
        randomizedCollection.insert(4);
        randomizedCollection.insert(2);
        randomizedCollection.insert(4);

        randomizedCollection.remove(4);
        randomizedCollection.remove(3);
        randomizedCollection.remove(4);
        randomizedCollection.remove(4);

        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
    }
}
