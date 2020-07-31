/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class ThreeSixFive {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        }
        if (z == 0 || x+y == z) {
            return true;
        }
        int gcd = 0;
        if (x > y) {
            gcd = gcd(x, y);
        } else {
            gcd = gcd(y, x);
        }
        return z % gcd == 0;

    }

    int gcd(int x, int y) {
        int r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }

    public static void main(String[] args) {
        ThreeSixFive threeSixFive = new ThreeSixFive();
        System.out.println(threeSixFive.canMeasureWater(2,4,7));
    }
}
