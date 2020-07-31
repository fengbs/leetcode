/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class ThreeFiveSeven {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        if (n >10) {
            n =10;
        }
        for (int i = 1; i <= n; ++i) {
            sum += compute(i);
        }
        return sum;
    }

    private int compute(int num) {
        if (num == 1) {
            return 10;
        } else {
            int sum = 9;
            int start = 9;
            for (int i = 2; i <= num; ++i) {
                sum *= start;
                --start;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ThreeFiveSeven threeFiveSeven = new ThreeFiveSeven();
        System.out.println(threeFiveSeven.countNumbersWithUniqueDigits(2));
    }

}
