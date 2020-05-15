/**
 * Created by lideqing@xiaomi.com on 20-2-17
 */
public class OneOneFive2 {

    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int [][]dp = new int[t.length()+1][s.length()+1];
        for (int i = 0 ; i < s.length()+1 ; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 0 ; i <t.length() ; ++i)
            for ( int j = 0 ; j < s.length() ; ++j ) {
            {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
                } else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        CommonUtil.printIntArr(dp);
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        OneOneFive2 oneOneFive2 = new OneOneFive2();
        System.out.println(oneOneFive2.numDistinct("rabbbit","rabbbit"));
    }
}
