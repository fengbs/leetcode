/**
 * Created by lideqing@xiaomi.com on 19-5-23
 */
public class SixTwoNine {
	public int kInversePairs(int n, int k) {
		int mod = 1000000007;//dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
		int maxK = n*(n-1)/2;
		if ( k > maxK ) {
			return 0;
		}

		if ( k ==0 || k == maxK ) {
			return 1;
		}

		long dp[][] = new long[n+1][k+1];
		dp[2][0] = 1;
		dp[2][1] = 1;
		for ( int i = 3 ; i <=n ; ++i ) {
			dp[i][0] =1;
			for ( int j = 1 ; j <=Math.min(k,i*(i-1)/2) ; ++j ) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]-(j<i?0:dp[i-1][j-i]) + mod)%mod;
			}
		}
		return (int)dp[n][k];

	}

	public static void main ( String []args ) {
		SixTwoNine sixTwoNine = new SixTwoNine();
		System.out.println(sixTwoNine.kInversePairs(1000,1000));
	}
}
