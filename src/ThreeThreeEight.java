/**
 * Created by lideqing@xiaomi.com on 20-3-31
 */
public class ThreeThreeEight {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num < 1) {
            return res;
        }
        int current = 1;
        for (int i = 1; i <= num; ++i) {
            if ((i & current) == 0) {
                current = current << 1;
            }
            res[i] = res[i - current] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeThreeEight threeThreeEight = new ThreeThreeEight();
        CommonUtil.printIntArr(threeThreeEight.countBits(2));
    }
}
