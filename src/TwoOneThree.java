/**
 * Created by lideqing@xiaomi.com on 19-12-19
 */
public class TwoOneThree {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < nums.length; ++i) {
            dp[i+1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        int max = dp[nums.length];
        for (int i = 0 ; i < nums.length-1 ; ++i) {
            dp[i+2] = Math.max(dp[i+1],dp[i] + nums[i]);
        }
        return max > dp[nums.length]?max:dp[nums.length];
    }

    public static void main(String[] args) {
        TwoOneThree twoOneThree = new TwoOneThree();
        int []input = {1};
        System.out.println(twoOneThree.rob(input));
    }
}
