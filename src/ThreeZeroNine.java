/**
 * Created by lideqing@xiaomi.com on 20-4-10
 */
public class ThreeZeroNine {
    int dp[];

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        dp = new int[prices.length];
        int max;
        int res = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = 0;

            for (int j = 0; j <= i - 1; ++j) {
                int sum = Math.max(((j - 2 >= 0 ? dp[j - 2] : 0) + prices[i] - prices[j]), dp[j]);
                if (sum > max) {
                    max = sum;
                }
            }
            dp[i] = max;
            if (res < max) {
                res = max;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        ThreeZeroNine threeZeroNine = new ThreeZeroNine();
        int[] input = {6, 1, 6, 4, 3, 0, 2};
        System.out.println(threeZeroNine.maxProfit(input));
    }
}
