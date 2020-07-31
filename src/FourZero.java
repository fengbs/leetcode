import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-22
 */
public class FourZero {
    private List<List<Integer>> allRes = new ArrayList<>();
    private int[] input;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        input = candidates;
        Arrays.sort(candidates);
        LinkedList<Integer> input = new LinkedList<>();
        dfs(target, input, 0);
        return allRes;
    }

    public void dfs(int target, LinkedList<Integer> res, int start) {
        for (int i = start; i < input.length; ++i) {
            if (i == start || input[i] != input[i - 1]) {
                if (input[i] < target) {
                    res.add(input[i]);
                    dfs(target - input[i], res, i + 1);
                    res.pollLast();
                } else if (input[i] == target) {
                    List<Integer> si = new ArrayList<>(res);
                    si.add(input[i]);
                    allRes.add(si);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        FourZero fourZero = new FourZero();
        int[] input = {2, 5, 2, 1, 2};
        CommonUtil.printList2(fourZero.combinationSum2(input, 5));
    }

}
