/**
 * Created by lideqing@xiaomi.com on 19-12-24
 */
public class ThreeNineSeven {

    public int integerReplacement(int n) {
        int num = 0;
        while (n != 1) {
            if (n == 0) {
                return num + 1;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else {
                int addNum = n + 1;
                int subNum = n - 1;
                int tem = addNum & subNum;
                if (tem != 0) {
                    addNum = addNum % tem;
                    subNum = subNum % tem;
                }
                if (addNum > subNum) {
                    n += 1;
                } else {
                    n -= 1;
                }
            }
            ++num;
        }
        return num;
    }

    public static void main(String[] args) {
        ThreeNineSeven threeNineSeven = new ThreeNineSeven();
        System.out.println(threeNineSeven.integerReplacement(11));
    }
}
