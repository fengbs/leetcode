/**
 * Created by lideqing@xiaomi.com on 19-4-1
 */
public class TwoZeroOne {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0 ||  n < m ) {
			return 0;
		}
		if ( m == n ) {
			return m;
		}
		int range = n - m;
		long bitBottom = 1;
		int res = 0;
		while ( bitBottom < n ) {
			long left = m % bitBottom;
			if ( (m&bitBottom) == bitBottom && range + left < bitBottom ) {
				res += bitBottom;
			}
			bitBottom*=2;
		}
		return res;
	}

	public static void main ( String []args ) {
		TwoZeroOne twoZeroOne = new TwoZeroOne();
		System.out.println(twoZeroOne.rangeBitwiseAnd(1,1));
	}
}
