import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-15
 */
public class OneFive {
	List<List<Integer>> threeSum( int []nums ) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for ( int i = 0 ; i < nums.length-2; ++i) {
			if ( i != 0 && nums[i] == nums[i-1] ) {
				continue;
			}
			int s = i + 1;
			int target = 0 - nums[i];
			int e = nums.length-1;
			while ( s < e ) {
				if ( nums[s] + nums[e] < target ) {
					++s;
					while ( s < nums.length &&nums[s] == nums[s-1] ) {
						++s;
					}
				} else if ( nums[s] + nums[e] > target ) {
					--e;
					while ( e > 0 && nums[e] == nums[e+1] ) {
						--e;
					}
				} else {
					List<Integer> temList = new ArrayList<>();
					temList.add(nums[i]);
					temList.add(nums[s]);
					temList.add(nums[e]);
					res.add(temList);
					++s;
					while ( s < nums.length && nums[s] == nums[s-1] ) {
						++s;
					}
					--e;
					while ( e > 0 && nums[e] == nums[e+1] ) {
						--e;
					}

				}
			}
		}
		return res;
	}

	public static void main ( String []args) {
		OneFive oneFive = new OneFive();
		int []input = {0,0,0};
		List<List<Integer>> res = oneFive.threeSum(input);
		CommonUtil.printList2(res);
	}

}
