/**
 * Created by lideqing@xiaomi.com on 19-4-3
 */
public class FourOne {
	public int firstMissingPositive(int[] nums) {
		for ( int i = 0 ; i < nums.length ; ++i ) {
			while ( nums[i] > 0 && nums[i] < nums.length && nums[i]!=i+1 && nums[i] != nums[nums[i]-1] ) {
				int tem = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[tem-1] = tem;
			}
		}
		for ( int i = 0 ; i < nums.length ; ++i ) {
			if ( nums[i] != i+1 ) {
				return i+1;
			}
		}
		return nums.length+1;
	}

	public static void main ( String []args ) {
		FourOne fourOne = new FourOne();
		int []nums = {1,1};
		System.out.println(fourOne.firstMissingPositive(nums));
	}
}
