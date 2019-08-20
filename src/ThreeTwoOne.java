import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 19-7-11
 */
public class ThreeTwoOne {
	public int [] maxNumber(int [] nums1,int [] nums2,int k) {

		int length1 = nums1==null?0:nums1.length;
		int length2 = nums2==null?0:nums2.length;
		int []dp = new int[length1+length2];
		int i = 0 ,j = 0,dpIndex = 0 ;
		while( i < length1 && j < length2 ) {
			if (nums1[i] == nums2[j]) {
				int temI = i;
				int temJ = j;
				while (temI < length1 && temJ < length2 && nums1[temI] == nums2[temJ]) {
					dp[dpIndex++] = nums1[temI];
					++temI;
					++temJ;
				}
				if (temI < length1 && temJ < length2) {
					if (nums1[temI] > nums2[temJ]) {
						dp[dpIndex++] = nums1[temI];
						i = temI + 1;
					} else {
						dp[dpIndex++] = nums2[temJ];
						j = temJ + 1;
					}
				} else if (temI >= length1) {
					i = temI;
				} else {
					j = temJ;
				}
			} else {
				if (nums1[i] > nums2[j]) {
					dp[dpIndex++] = nums1[i++];
				} else {
					dp[dpIndex++] = nums2[j++];
				}
			}
		}
		while ( i < length1 ) {
			dp[dpIndex++] = nums1[i++];
		}
		while (j < length2 ) {
			dp[dpIndex++] = nums2[j++];
		}

		i = 0 ;
		int allLength = length1 + length2;
		int [] result = new int[k];
		int pre = 0 ;
		while ( i < k ) {
			int max = 0;
			int currentLength = allLength - k + i + 1;
			for ( int ii = pre ; ii < currentLength; ++ii ) {
				if ( dp[ii] > max ) {
					max = dp[ii];
					pre = ii;
				}
			}
			result[i] = dp[pre++];
			++i;
		}
		return result;
	}

	public static void main ( String []args) {
		ThreeTwoOne threeTwoOne = new ThreeTwoOne();
		int nums1[] = {3,4,6,5};
		int nums2[] = {9,1,2,5,8,3};
		int res[] = threeTwoOne.maxNumber(nums1,nums2,5);//3605559
		for ( int i = 0 ; i < res.length ; ++i ) {
			System.out.print(res[i] + ",");
		}
	}
}
