/**
 * Created by lideqing@xiaomi.com on 19-4-28
 */
public class OneOneTwo {
	public int maxProfit( int[] prices ) {
		if ( prices == null || prices.length < 2 ) {
			return 0;
		}
		int start = 0;
		int sum = 0 ;
		for ( int i = 1 ; i < prices.length ; ++i ) {
			if ( prices[i] < prices[i-1] ) {
				sum += prices[i-1] - prices[start];
				start = i;
			}
		}
		sum += prices[prices.length-1] - prices[start];
		return sum;
	}
}
