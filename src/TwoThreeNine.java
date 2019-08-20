/**
 * Created by lideqing@xiaomi.com on 19-7-30
 */
public class TwoThreeNine {
	public int[] maxSlidingWindow(int [] nums , int k ) {
		if ( nums == null || nums.length == 0 ) {
			int []res = new int[0];
			return res;
		}
		if ( k == 1) {
			return nums;
		}
		if ( nums.length < k) {
			int []res = new int[1];
			res[0] = Integer.MIN_VALUE;
			for ( int i = 0 ; i < nums.length ; ++i ) {
				if ( res[0] < nums[i] ) {
					res[0] = nums[i];
				}
			}
			return res;
		}
		int []res = new int[nums.length -k + 1];
		int max = nums[0];
		int maxI = 0;
		int nextMax = Integer.MIN_VALUE;
		int nextI =0;
		for ( int i = 1 ; i < nums.length ; ++i ) {
			if ( max <= nums[i] ) {
				max = nums[i];
				maxI = i;
				nextMax = Integer.MIN_VALUE;
			} else {
				if (nextMax < nums[i]) {
					nextMax = nums[i];
					nextI = i;
				}
			}

			if ( maxI < i - k + 1 ) {
				maxI = nextI;
				max = nextMax;
				nextMax = Integer.MIN_VALUE;
				for ( int j = maxI+1 ; j <=i ; ++j ) {
					if (nextMax < nums[j]) {
						nextMax = nums[j];
						nextI = j;
					}
				}
			}
			if ( i >= k -1 ) {
				res[i-k+1] = max;
			}
		}
		return res;
	}
	public static void main ( String []args ) {
		int nums[] = {9,10,9,-7,-4,-8,2,-6,5};
		//int nums[] = {9,8,7,6,5,4,3,2,1,0};
		TwoThreeNine twoThreeNine  = new TwoThreeNine();
		int []res = twoThreeNine.maxSlidingWindow(nums , 5 );
		for ( int i = 0 ; i < res.length ; ++i ) {
			System.out.println(res[i]);
		}
	}

}
