/**
 * Created by lideqing@xiaomi.com on 19-3-19
 */
public class NineFourZero {
	public static void main (String []args) {
		Solution solution = new Solution();
		System.out.println(solution.distinctSubseqII("blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr"));
	}
}


class Solution {
	private static final int MOD = 1000000007;
	public int distinctSubseqII(String S) {
		int []digit = new int[26];
		int sum = 0;
		for ( int i = 0 ; i < S.length() ; ++i ) {
			if ( digit[S.charAt(i)-'a'] == 0 ) {
				digit[S.charAt(i)-'a'] = sum + 1;
				sum += sum +1;
			} else {
				int curDigitSum = sum + 1 - digit[S.charAt(i)-'a'];
				curDigitSum%=MOD;
				sum += curDigitSum;
				digit[S.charAt(i)-'a'] += curDigitSum;

			}
			digit[S.charAt(i)-'a']%=MOD;
			sum %= MOD;
		}
		return sum<0?sum+MOD:sum;
	}
}