/**
 * Created by lideqing@xiaomi.com on 19-6-10
 */
public class FourFourZero {
	public int findKthNumber(int n,int k) {
		int i = 1;
		int start = 1;
		int pow = 1;
		while ( i < k ) {
			for ( int j = 0 ; j < 3 ; ++j ) {
				for( int item = start * pow ; item < start*(pow + 1) ; ++item ) {
					if ( item > n ) {
						break;
					} else if ( i >= k ){
						return item;
					} else {
						++i;
					}
				}
				pow *= 10;

			}
			pow = 1;
			start +=1;
		}
		return 1;
	}

	public static void main ( String []args ) {
		FourFourZero fourFourZero = new FourFourZero();
		System.out.println(fourFourZero.findKthNumber(109,3));
	}

}
