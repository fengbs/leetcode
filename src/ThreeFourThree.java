/**
 * Created by lideqing@xiaomi.com on 20-6-8
 */
public class ThreeFourThree {
    public int integerBreak(int n) {
        if(n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int dp[] = new int[n+1];
        for (int i = 1 ; i < dp.length ; ++i) {
            dp[i] = -1;
        }
        dp[0] = 1;
        int []nums= {1,2,3};
        for (int i = 0 ; i < nums.length ; ++i) {
            for (int j = nums[i]; j <= n ; ++j) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]] * nums[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ThreeFourThree threeFourThree = new ThreeFourThree();
        System.out.println(threeFourThree.integerBreak(4));
    }
}
