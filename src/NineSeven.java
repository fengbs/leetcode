/**
 * Created by lideqing@xiaomi.com on 19-5-7
 */
public class NineSeven {

	public boolean isInterleave(String s1, String s2, String s3) {
		int s1Length = s1 == null ? 0 : s1.length();
		int s2Length = s2 == null ? 0 : s2.length();
		int s3Length = s3 == null ? 0 : s3.length();
		if (s1Length + s2Length != s3Length) {
			return false;
		}
		boolean dp[][] = new boolean[s1Length + 1][s2Length + 1];
		dp[0][0] = true;
		for (int i = 0; i <= s1.length(); ++i) {
			for (int j = 0; j <= s2.length(); ++j) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i > 0 && dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					dp[i][j] = true;
				} else if (j > 0 && dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		NineSeven nineSeven = new NineSeven();
		System.out.println(nineSeven.isInterleave("", "", ""));
	}

}
