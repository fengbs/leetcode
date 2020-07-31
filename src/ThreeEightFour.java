import java.util.Random;

/**
 * Created by lideqing@xiaomi.com on 20-5-30
 */
public class ThreeEightFour {

    public static class ddd {
        int[] nums;
        int shuffleNums[];
        Random random = new Random();

        public ddd(int[] nums) {
            this.nums = nums;
            shuffleNums = new int[nums.length];
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (nums == null) {
                return null;
            }
            for (int i = 0; i < nums.length; ++i) {
                shuffleNums[i] = nums[i];
            }
            for (int i = 0; i < nums.length; ++i) {
                int next = i + random.nextInt(nums.length - i);
                int tem = nums[i];
                nums[i] = nums[next];
                nums[next] = tem;
            }
            return nums;
        }
    }
}
