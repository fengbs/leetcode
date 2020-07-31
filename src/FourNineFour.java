/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class FourNineFour {
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        int[] dp = new int[2002];
        int[] tem = new int[2002];
        dp[nums[0]+1000] += 1;
        dp[1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < 2002; ++j) {
                if (dp[j] != 0) {
                    tem[nums[i] + j] += dp[j];
                    tem[j - nums[i]] += dp[j];
                }
            }
            for (int j = 0; j < 2002; ++j) {
                dp[j] = tem[j];
                tem[j] = 0;
            }
        }
        return dp[S+1000];

    }

    public static void main(String[] args) {
        FourNineFour fourNineFour = new FourNineFour();
        int [] input = {0, 1};
        System.out.println(fourNineFour.findTargetSumWays(input,1));
    }
}
