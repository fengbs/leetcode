/**
 * Created by lideqing@xiaomi.com on 19-4-28
 */
public class OneTwoThree {
	public int maxProfit( int[] prices ) {
		if ( prices == null || prices.length < 2 ) {
			return 0;
		}
		int length = prices.length;
		int incrDP[] = new int[length];
		int descDP[] = new int[length];
		int min = prices[0];
		int maxValue = 0;
		for ( int i = 0 ; i < prices.length ; ++i ) {
			if ( maxValue < prices[i] - min ) {
				maxValue = prices[i] - min;
			}
			if ( min > prices[i] ) {
				min = prices[i];
			}
			incrDP[i] = maxValue;
		}
		maxValue = 0;
		int max = prices[prices.length-1];
		for ( int i = prices.length - 1 ; i >=0 ; --i ) {
			if ( maxValue < max - prices[i] ) {
				maxValue = max - prices[i];
			}
			if ( max < prices[i] ) {
				max = prices[i];
			}
			descDP[i] = maxValue;
		}
		int res = 0;
		for ( int i = 0 ; i < length-1 ; ++i ) {
			res = Math.max(res,incrDP[i]+descDP[i+1]);
		}
		res = Math.max(res,incrDP[length-1]);
		res = Math.max(res,descDP[0]);
		return res;
	}

	public static void main(String []args) {
		OneTwoThree oneTwoThree = new OneTwoThree();
		int input[] = {1,2,3,4,5};
		System.out.println(oneTwoThree.maxProfit(input));

	}

}
