/**
 * Created by lideqing@xiaomi.com on 20-3-17
 */
public class ThreeZeroZero {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                --j;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ThreeZeroZero threeZeroZero = new ThreeZeroZero();
        int []input = {10,9,2,5,3,7,101,18};
        System.out.println(threeZeroZero.lengthOfLIS(input));
    }
}
