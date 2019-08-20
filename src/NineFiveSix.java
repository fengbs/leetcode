/**
 * Created by lideqing@xiaomi.com on 19-7-22
 */
public class NineFiveSix {
	public int tallestBillboard(int [] rods) {
		if ( rods == null || rods.length == 0 ) {
			return 0;
		}
		int length = rods.length;
		int sum = 0;
		for ( Integer i : rods ) {
			sum  += i;
		}
		if ( sum % 2 != 0 ) {
			return 0;
		}
		int V = sum/2;
		int dp [] = new int[V+1];
		for ( int i = 0 ; i < length ; ++i ) {
			for ( int j = V ; j >= rods[i]  ; --j ) {
				dp[j] = Math.max(dp[j],dp[j-rods[i]]+rods[i]);
			}
		}
		return dp[V] == V?V:0;
	}

	public static void main ( String []args ) {
		NineFiveSix nineFiveSix = new NineFiveSix();
		int []input = {2,3,4,5,6};
		System.out.println(nineFiveSix.tallestBillboard(input));
	}
}
