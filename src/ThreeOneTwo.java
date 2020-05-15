/**
 * Created by lideqing@xiaomi.com on 20-4-9
 */
public class ThreeOneTwo {
    private int[] nums;
    private int[][] dp;

    int dfs(int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int max = 0;
        int tem;
        for (int i = start; i <= end; ++i) {
            int left = (i == start) ? 0 : dfs(start, i - 1);
            int right = (i == end) ? 0 : dfs(i + 1, end);
            tem = left + right
                + ((start == 0) ? 1 : nums[start - 1])
                * nums[i]
                * ((end == nums.length - 1) ? 1 : nums[end + 1]);
            /*if (left > right) {
                tem += left * right * (end == nums.length - 1 ? 1 : nums[end + 1]);
                tem += left * (start == 0 ? 1 : nums[start - 1]) * (end == nums.length - 1 ? 1 : nums[end + 1]);
            } else {
                tem += left * right * (start == 0 ? 1 : nums[start - 1]);
                tem += right * (start == 0 ? 1 : nums[start - 1]) * (end == nums.length - 1 ? 1 : nums[end + 1]);
            }*/
            if (tem > max) {
                max = tem;
            }
        }
        dp[start][end] = max;
        return max;
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                dp[i][j] = -1;
            }
        }
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    public static void main(String[] args) {
        ThreeOneTwo threeOneTwo = new ThreeOneTwo();
        int[] nums = {1};
        System.out.println(threeOneTwo.maxCoins(nums));
        System.out.println("---------");
    }
}
