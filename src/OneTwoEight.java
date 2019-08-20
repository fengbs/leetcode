import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-7-31
 */
public class OneTwoEight {
	public int longestConsecutive( int [] nums ) {
		if ( nums == null || nums.length == 0 ) {
			return 0;
		}
		boolean isUsed[] = new boolean[nums.length];
		Map<Integer,Integer> numMap = new HashMap<>();
		for ( int i = 0 ; i < nums.length ; ++i) {
			numMap.put(nums[i],i);
		}
		int maxLength = 1;
		for ( int i = 0 ; i < nums.length ;++i ) {
			if ( !isUsed[i] ) {
				isUsed[i] = true;
				int temI = nums[i]+1;
				int temLength = 1;
				Integer index = 0;
				while ( numMap.containsKey(temI) ) {
					isUsed[numMap.get(temI)] = true;
					temI++;
					++temLength;
				}
				temI = nums[i]-1;
				while ( numMap.containsKey(temI) ) {
					isUsed[numMap.get(temI)] = true;
					--temI;
					++temLength;
				}
				if ( temLength > maxLength ) {
					maxLength = temLength;
				}

			}
		}
		return maxLength;
	}

	public static void main( String []args ) {
		OneTwoEight oneTwoEight = new OneTwoEight();
		int []nums = {0,-1};
		System.out.println(oneTwoEight.longestConsecutive(nums));
	}
}
