/**
 * Created by lideqing@xiaomi.com on 19-8-2
 * not solve
 */
public class SevenTwo {

	public int minDistance(String word1,String word2) {
		if ( word1 == null || word1.length() == 0 ) {
			return word2 ==null? 0 : word2.length();
		}
		if ( word2 == null || word2.length() == 0 ) {
			return word1 ==null? 0 : word1.length();
		}
		int length1 = word1.length();
		int length2 = word2.length();
		int dp[][] = new int[length1+1][length2+1];
		for ( int i = 0 ; i < word1.length() ; ++i ) {
			for ( int j = 0 ; j < word2.length() ; ++j ) {
				if ( word1.charAt(i) == word2.charAt(j) ) {
					dp[i+1][j+1] = dp[i][j] + 1;
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
				}
			}
		}
		int common = Math.abs(length1-length2);
		return Math.max(length1,length2) - common + (common - dp[length1][length2]);


	}
	public static void main(String[] args) {
		SevenTwo sevenTwo = new SevenTwo();
		System.out.println(sevenTwo.minDistance("intention","execution"));
	}

}
