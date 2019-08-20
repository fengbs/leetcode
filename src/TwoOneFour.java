/**
 * Created by lideqing@xiaomi.com on 19-7-26
 */
public class TwoOneFour {
	public String shortestPalindrome( String s ) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < s.length() ; ++i ) {
			sb.append("#" + s.charAt(i));
		}
		sb.append("#");
		int i = 0 ;
		int length = sb.length();
		int []dp = new int[length];
		int max = 0 ;
		int maxJ = 0;
		while ( i < length ) {
			if ( i < max ) {
				dp[i] = Math.min(dp[2*maxJ-i],max-i);
			} else {
				dp[i] = 1;
			}
			while(i>=dp[i] && i + dp[i] < length && sb.charAt(i-dp[i]) == sb.charAt(i+dp[i])) {
				dp[i]++;
			}
			if ( dp[i] + i > max ) {
				max = dp[i] + i ;
				maxJ = i;
			}
			++i;
		}
		int res = 0;
		for ( int j = length-1 ; j >= 0 ; --j ) {
			if (j - dp[j] <= 0 ) {
				res =  j;
				break;
			}
		}
		res += dp[res]-1;
		res= (res == 0) ? 0 : (res -1)/2;
		StringBuilder before = new StringBuilder();
		for ( int j = s.length()-1; j > res ; --j ) {
			before.append(s.charAt(j));
		}
		return before.toString() + s;
	}

	public static void main ( String []args ) {
		TwoOneFour twoOneFour = new TwoOneFour();
		System.out.println(twoOneFour.shortestPalindrome("a"));
	}

}
