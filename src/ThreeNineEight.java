import java.util.Random;

/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class ThreeNineEight {
    int []nums;
    Random random;

    public ThreeNineEight(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int cur = 1;
        int index = 0;
        for (int i = 0 ; i < nums.length ; ++i) {
            if (nums[i] == target) {
                int tem = random.nextInt(cur);
                if (tem < 1) {
                    index = i;
                }
                ++cur;
            }
        }
        return index;
    }
}
