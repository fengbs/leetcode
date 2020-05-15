import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-7
 */
public class OneOneEight {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
        }
        for (int i = 1; i < numRows; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j == i) {
                    res.get(i).add(1);
                } else {
                    res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OneOneEight oneOneEight = new OneOneEight();
        CommonUtil.printList2(oneOneEight.generate(8));
    }
}
