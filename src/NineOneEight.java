/**
 * Created by lideqing@xiaomi.com on 19-3-25
 */
public class NineOneEight {
	private static final int MIN_INT = 30001;
	public int maxSubarraySumCircular(int[] A) {
		int max = A[0],current = 0,min=MIN_INT,currentMin=0,sum=0;

		for( int i = 0 ; i < A.length ; ++i ) {
			sum += A[i];
			if ( current <= 0 ) {
				current = A[i];
			} else {
				current += A[i];
			}
			if (current > max ) {
				max = current;
			}

			if ( i == 0 ) {
				continue;
			} else {
				if ( currentMin > 0 ) {
					currentMin = A[i];
				} else {
					currentMin += A[i];
				}
				if ( min > currentMin ) {
					min = currentMin;
				}
			}
		}
		return min==MIN_INT?max:(max>sum - min?max:sum-min);
	}

	public static void main (String []args) {
		NineOneEight nineOneEight = new NineOneEight();
		int A[] = {-5};
		System.out.println(nineOneEight.maxSubarraySumCircular(A));
	}
}
