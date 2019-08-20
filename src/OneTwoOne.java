/**
 * Created by lideqing@xiaomi.com on 19-4-28
 */
public class OneTwoOne {
	public int maxProfit( int[] prices ) {
		if ( prices == null || prices.length < 2 ) {
			return 0;
		}
		int max = 0;
		int min = prices[0];
		for ( Integer i : prices ) {
			if ( i < min ) {
				min = i;
			}
			if ( i - min > max ) {
				max = i - min;
			}
		}
		return max;
	}

}
