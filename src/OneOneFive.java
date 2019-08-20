/**
 * Created by lideqing@xiaomi.com on 19-4-8
 */
public class OneOneFive {
	public int numDistinct(String s, String t) {
		int lengthS = s.length();
		int lengthT = t.length();
		if ( s.length() < t.length() ) {
			return 0;
		}
		int dp[][] = new int[s.length()+1][t.length()+1];
		dp[0][0] = 1;
		for ( int i = 0 ; i < s.length() ; ++i ) {
			dp[i][0] = 1;
		}
		for ( int i = 1 ; i <= lengthT ; ++i ) {
			for ( int j = 1 ; j <= lengthS ; ++j ) {
				dp[j][i] = dp[j-1][i];
				if (s.charAt(j - 1) == t.charAt(i-1)) {
					dp[j][i] += dp[j - 1][i - 1];
				}
			}
		}
		return dp[s.length()][t.length()];

	}

	public static void main ( String []args ) {
		OneOneFive oneOneFive = new OneOneFive();
		System.out.println(oneOneFive.numDistinct("",""));
	}
}
