import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-22
 */
public class ThreeNine {

    int[] nums;

    List<List<Integer>> allRes = new ArrayList<>();

    void dfs(int target, int start, LinkedList<Integer> res) {
        for (int i = start; i < nums.length; ++i) {
            if (target == nums[i]) {
                res.add(nums[i]);
                allRes.add(new ArrayList<>(res));
                res.pollLast();
                return;
            } else if (target < nums[i]) {
                return;
            } else {
                int temTarget = target;
                int size = res.size();
                while (temTarget > nums[i]) {
                    temTarget -= nums[i];
                    res.add(nums[i]);
                    if (temTarget > nums[i]) {
                        dfs(temTarget, i + 1, res);
                    } else if (temTarget == nums[i]) {
                        res.add(nums[i]);
                        allRes.add(new ArrayList<>(res));
                        break;
                    } else {
                        break;
                    }
                }
                while (res.size() > size) {
                    res.pollLast();
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        LinkedList<Integer> input = new LinkedList<>();
        dfs(target, 0, input);
        return allRes;
    }

    public static void main(String[] args) {
        ThreeNine threeNine = new ThreeNine();
        int[] input = {2, 3, 6, 7};
        CommonUtil.printList2(threeNine.combinationSum(input, 7));
    }
}
