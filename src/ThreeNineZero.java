/**
 * Created by lideqing@xiaomi.com on 20-6-11
 */
public class ThreeNineZero {
    public int lastRemaining(int n) {
        return n==1?1:(n/2+1-lastRemaining(n/2));
    }
}
