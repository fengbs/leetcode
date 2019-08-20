/**
 * Created by lideqing@xiaomi.com on 19-8-20
 */
public class NineSix {
    public int numTrees(int n) {
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int cur = 2;
        while ( cur <= n ) {
            for ( int i = 0 ; i < cur ; ++i ) {
                dp[cur] += dp[i] * dp[cur-i-1];
            }
            ++cur;
        }
        return dp[n];
    }

    public static void main ( String []args ) {
        NineSix nineSix = new NineSix();
        System.out.println(nineSix.numTrees(2));
    }
}
