/**
 * Created by lideqing@xiaomi.com on 19-8-1
 */
public class OneThreeFive {
	public int candy(int[] ratings) {
		if ( ratings == null || ratings.length == 0 ) {
			return 0;
		}
		int []dp = new int[ratings.length];
		for ( int i = 1 ; i < ratings.length ; ++i ) {
			if ( ratings[i] < ratings[i-1]) {
				dp[i-1] = Math.max(dp[i] + 1,dp[i-1]);
				int k = i -1 ;
				while ( k -1 >= 0 && ratings[k-1] > ratings[k] ) {
					dp[k-1] = Math.max(dp[k] + 1,dp[k-1]);
					--k;
				}
			} else if ( ratings[i] > ratings[i-1]) {
				dp[i] = dp[i-1] + 1;
			}
		}
		int sum = 0 ;
		for ( int i = 0 ; i < dp.length ; ++i ) {
			sum += dp[i];
		}
		return sum + ratings.length;
	}

	public static void main ( String []args) {
		OneThreeFive oneThreeFive = new OneThreeFive();
		int []candy =  {0,1,2,3,2,1};
		System.out.println(oneThreeFive.candy(candy));
	}
}
