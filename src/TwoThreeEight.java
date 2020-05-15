/**
 * Created by lideqing@xiaomi.com on 20-3-20
 */
public class TwoThreeEight {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            res[i] = sum * res[i];
        }
        return res;
    }
}
