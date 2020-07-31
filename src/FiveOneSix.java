/**
 * Created by lideqing@xiaomi.com on 20-5-26
 */
public class FiveOneSix {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < s.length(); ++i) {
            for (int j = 0; j < s.length() - i; ++j) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = (j + 1 > j + i - 1 ? 0 : dp[j + 1][j + i - 1]) + 2;
                } else {
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        FiveOneSix fiveOneSix = new FiveOneSix();
        System.out.println(fiveOneSix.longestPalindromeSubseq("abbaabb"));
    }
}
