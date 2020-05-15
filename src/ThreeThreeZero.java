/**
 * Created by lideqing@xiaomi.com on 20-4-2
 */
public class ThreeThreeZero {

    public int minPatches(int[] nums, int n) {
        long pre = 0;
        int count = 0;
        if (nums != null) {
            for (int i = 0; i < nums.length; ++i) {
                if (pre < nums[i] - 1) {
                    while (pre < nums[i] - 1) {
                        if (pre >= n) {
                            return count;
                        }
                        pre += pre + 1;
                        count++;
                    }
                }
                pre += nums[i];
                if (pre >= n) {
                    return count;
                }
            }
        }
        while (pre < n) {
            pre += pre + 1;
            ++count;
        }
        return count;

    }

    public static void main(String[] args) {
        ThreeThreeZero threeThreeZero = new ThreeThreeZero();
        int[] input = {1,2,31,33};
        System.out.println(threeThreeZero.minPatches(input, 2147483647));
    }
}
