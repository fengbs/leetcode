import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class TwoSevenNine {
    public int numSquares(int n) {
        //find candidate
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        int num = 1;
        while (num * num <= n) {
            list.add(num * num);
            ++num;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = -1;
        }
        for (int i = 0; i < list.size(); ++i) {
            for (int j = list.get(i); j <= n; ++j) {
                if (dp[j - list.get(i)] != -1) {
                    if (dp[j] == -1) {
                        dp[j] = dp[j - list.get(i)] + 1;
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - list.get(i)] + 1);
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TwoSevenNine twoSevenNine = new TwoSevenNine();
        System.out.println(twoSevenNine.numSquares(16));
    }
}
