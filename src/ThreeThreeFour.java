/**
 * Created by lideqing@xiaomi.com on 20-4-2
 */
public class ThreeThreeFour {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a1 = nums[0];
        int a2 = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            if (a2 == Integer.MIN_VALUE) {
                if (nums[i] > a1) {
                    a2 = nums[i];
                } else {
                    a1 = nums[i];
                }
            } else {
                if (nums[i] > a2) {
                    return true;
                } else {
                    if (a1 >= nums[i]) {
                        a1 = nums[i];
                    } else if (a2 > nums[i]) {
                        a2 = nums[i];
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeThreeFour threeThreeFour = new ThreeThreeFour();
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(threeThreeFour.increasingTriplet(input));
    }
}
