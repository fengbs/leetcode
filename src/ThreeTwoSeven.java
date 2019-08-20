/**
 * Created by lideqing@xiaomi.com on 19-7-1
 */
public class ThreeTwoSeven {

	public int countRangeSum( int[] nums,int lower,int upper ) {
		if ( nums == null || nums.length == 0 ) {
			return 0;
		}
		long [] sumArr = new long[nums.length+1];
		long sum = 0 ;
		sumArr[0] = 0;
		for ( int i = 0 ; i < nums.length ; ++i ) {
			sum += nums[i];
			sumArr[i+1] = sum;
		}

		int returnSum = 0 ;
		for ( int i = 1 ; i < sumArr.length ; ++i ) {
			for ( int j = 1 ; j <= i ; ++j) {
				long temSum = sumArr[i-1] - sumArr[j-1] + nums[i-1];
				if ( temSum >= lower && temSum <=upper ) {
					returnSum++;
				}
			}
		}
		return returnSum;
	}

	public static void main ( String []args ) {
		ThreeTwoSeven threeTwoSeven = new ThreeTwoSeven();
		int []a = {-2147483647,0,-2147483647,2147483647};
		System.out.println(threeTwoSeven.countRangeSum(a,-564,3864));
	}
}
