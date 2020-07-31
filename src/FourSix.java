import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-21
 */
public class FourSix {
    private int[] nums;
    List<List<Integer>> list = new ArrayList<>();

    void dfs(int start) {
        if (start >= nums.length - 1) {
            List<Integer> newList = new ArrayList<>();
            for (int num : nums) {
                newList.add(num);
            }
            list.add(newList);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            int tem = nums[start];
            nums[start] = nums[i];
            nums[i] = tem;
            dfs(start + 1);
            tem = nums[start];
            nums[start] = nums[i];
            nums[i] = tem;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return list;
        }
        this.nums = nums;
        dfs(0);
        return list;
    }

    public static void main(String[] args) {
        FourSix fourSix = new FourSix();
        int[] nums = {1, 2, 3, 4, 5};
        CommonUtil.printList2(fourSix.permute(nums));

    }
}
