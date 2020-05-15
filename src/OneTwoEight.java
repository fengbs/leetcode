import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-7-31
 */
public class OneTwoEight {
	/*public int longestConsecutive( int [] nums ) {
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
	}*/

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left;
        int right;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                continue;
            }
            map.put(i, 1);
            left = i;
            right = i;
            int current = i;
            int newSum = 1;
            if (map.containsKey(current - 1)) {
                left = i - map.get(current - 1);
                newSum += map.get(current - 1);
            }

            current = i;
            if (map.containsKey(current + 1)) {
                right = i + map.get(current + 1);
                newSum += map.get(current + 1);
            }
            map.put(left, newSum);
            map.put(right, newSum);
        }
        int max = 0;
        for (int res : map.values()) {
            if (res > max) {
                max = res;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        OneTwoEight oneTwoEight = new OneTwoEight();
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        System.out.println(oneTwoEight.longestConsecutive(nums));
    }
}
