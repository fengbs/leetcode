import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class ThreeSixEight {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = 1;
            pre[i] = i;
        }
        int max = 1;
        int maxI = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] % nums[i] == 0) {
                    if (dp[i] + 1 > dp[j]) {
                        pre[j] = i;
                        dp[j] = dp[i] + 1;
                    }
                    if (dp[j] > max) {
                        max = dp[j];
                        maxI = j;
                    }
                }
            }
        }
        int i = maxI;
        do {
            res.add(nums[i]);
            if(i == pre[i]) {
                break;
            }
            i=pre[i];
        } while(true);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ThreeSixEight threeSixEight = new ThreeSixEight();
        int []input = {2,3,8,9,27};
        CommonUtil.printList(threeSixEight.largestDivisibleSubset(input));
    }
}
