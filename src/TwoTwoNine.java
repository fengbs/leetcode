import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-3-20
 */
public class TwoTwoNine {
    public List<Integer> majorityElement(int[] nums) {
        int num = 1;
        int deCount = 0;
        int current = nums[0];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != current) {
                ++deCount;
                if (deCount >= 2) {
                    num -= 1;
                    deCount -= 2;
                }
                if (num == 0) {
                    num = 1;
                    current = nums[i];
                }
            }
        }
        if (num > 1 || deCount == 0) {
            res.add(current);
        } else {
            return res;
        }
        num = 0;
        deCount = 0;
        current = res.get(0);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == res.get(0)) {
                deCount++;
            } else if (deCount>=2) {
                num-=1;
                deCount-=2;
            }
        }
        return res;
    }
}
