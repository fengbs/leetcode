/**
 * Created by lideqing@xiaomi.com on 19-12-12
 */
public class TwoZeroNine {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (start <= i && sum >= s) {
                int num = i -start +1;
                if (num == 1) {
                    return 1;
                }
                if (num < minNum) {
                    minNum = num;
                }
                sum -= nums[start];
                ++start;
            }
        }
        return minNum;

    }

    public static void main (String []args) {
        TwoZeroNine twoZeroNine = new TwoZeroNine();
        System.out.println(twoZeroNine.minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }
}
