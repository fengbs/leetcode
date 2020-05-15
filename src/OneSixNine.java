/**
 * Created by lideqing@xiaomi.com on 20-4-27
 */
public class OneSixNine {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == current) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                count = 1;
                current = nums[i];
            }
        }
        return current;
    }

    public static void main(String[] args) {
        OneSixNine oneSixNine = new OneSixNine();
        int []input = {2,2,1,1,1,2,2};
        System.out.println(oneSixNine.majorityElement(input));
    }
}
