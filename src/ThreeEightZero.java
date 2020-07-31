import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-5-29
 */
public class ThreeEightZero {
    public static class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.get(val) != null) {
                return false;
            } else {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (list.size()==0) {
                return false;
            }
            if (map.get(val) == null) {
                return false;
            } else {
                int index = map.get(val);
                map.put(list.get(list.size()-1),index);
                list.set(index,list.get(list.size()-1));
                list.remove(list.size()-1);
                map.put(val,null);
                return true;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int length = list.size();
            Random rand = new Random();
            int index = Math.abs(rand.nextInt())%length;
            return list.get(index);
        }
    }

    public static void main(String[] args) {
        RandomizedSet threeEightZero = new RandomizedSet();
        threeEightZero.insert(0);
        threeEightZero.insert(1);
        threeEightZero.remove(0);
        threeEightZero.insert(2);
        threeEightZero.remove(1);
        System.out.println(threeEightZero.getRandom());

    }
}
