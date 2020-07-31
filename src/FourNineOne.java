import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-5-27
 */
public class FourNineOne {
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> res = new LinkedList<>();
    int[] nums;

    void dfs(int start, LinkedList<Integer> list) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {

            if (list.getLast() <= nums[i]) {
                if (!set.contains(nums[i])) {
                    list.addLast(nums[i]);
                    dfs(i + 1, list);
                    list.pollLast();
                    set.add(nums[i]);
                }
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                list.addLast(nums[i]);
                dfs(i + 1, list);
                list.pollLast();
                set.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourNineOne fourNineOne = new FourNineOne();
        int[] input = {4, 6, 7, 7};
        System.out.println(fourNineOne.findSubsequences(input));
    }
}
