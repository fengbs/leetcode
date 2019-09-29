/**
 * Created by lideqing@xiaomi.com on 19-8-27
 */
public class SixTwo {
    public int uniquePaths(int m, int n) {
        if ( m == 0 || n == 0 ) {
            return 0;
        }
        if ( m == 1 || n == 1 ) {
            return 1;
        }
        int sum = m+n-2;
        int res = 1;
        int div = 1;
        for ( int i = 0 ; i < m - 1 ; ++i ) {
            res = res * sum;
            div *= m-1-i;
            --sum;
        }
        return res/div;
    }
    public static void main ( String []args ) {
        SixTwo sixTwo = new SixTwo();
        System.out.println(sixTwo.uniquePaths(2,3));
    }
}
