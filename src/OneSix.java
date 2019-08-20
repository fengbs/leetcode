import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 19-8-15
 */
public class OneSix {

	public int threeSumClosest(int[]nums,int target) {
		Arrays.sort(nums);
		int minSize = Integer.MAX_VALUE;
		int res = 0;
		for ( int i = 0 ; i < nums.length-2 ; ++i ) {
			int start = i+1;
			int end = nums.length-1;
			int newTarget = target - nums[i];
			while (start < end) {
				int minus = newTarget - nums[start] - nums[end];
				int absMinus = Math.abs(minus);
				if (minus == 0 ) {
					return target;
				} else {
					if (absMinus < minSize) {
						minSize = absMinus;
						res = nums[start] + nums[end] + nums[i];
						System.out.println(start + " " + end + " " + nums[i] );
					}
					if ( minus > 0 ) {
						start++;
						while ( start < nums.length -1 && nums[start] == nums[start - 1] ) {
							start++;
						}
					} else {
						end--;
						while ( end > 0 &&  nums[end] == nums[end + 1] ) {
							end--;
						}
					}
				}
			}
		}
		return res;
	}

	public static void main ( String []args ) {
		OneSix oneSix = new OneSix();
		int []nums = {0,1,2,3};
		System.out.println(oneSix.threeSumClosest(nums,3));
	}

}
