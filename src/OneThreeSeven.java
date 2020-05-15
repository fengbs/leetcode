/**
 * Created by lideqing@xiaomi.com on 19-11-26
 */
public class OneThreeSeven {
    public int singleNumber(int[] nums) {
        short[] num = new short[32];
        for (int i = 0; i < nums.length; ++i) {
            putInSum(nums[i], num);
        }
        int res = 0;
        for (int i = num.length - 1; i >= 0; --i) {
            res = (res << 1) + num[i];
        }
        return res;
    }

    private void putInSum(int number, short[] num) {
        int i = 0;
        while (number != 0) {
            if (number % 2 > 0) {
                num[i] += number % 2;
                if (num[i] == 3) {
                    num[i] = 0;
                }
            }
            ++i;
            number = number >> 1;
        }
    }

    public static void main(String[] args) {
        OneThreeSeven oneThreeSeven = new OneThreeSeven();
        int[] input = { 99};
        System.out.println(oneThreeSeven.singleNumber(input));
    }
}
