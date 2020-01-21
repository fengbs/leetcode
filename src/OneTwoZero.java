import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-9-29
 */
//TODO 看看耗时
public class OneTwoZero {
    public int minimumTotal(List<List<Integer>> triangle) {
        LinkedList<Integer> dp = new LinkedList<>();
        if (triangle.size() == 0) {
            return 0;
        }
        dp.addLast(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); ++i) {
            int first = 0;
            int second = 0;
            List<Integer> ceng = triangle.get(i);
            for (int j = 0; j < ceng.size(); ++j) {
                if (j == 0) {
                    second = dp.pollFirst();
                    dp.addLast(second + ceng.get(j));
                } else if (j == ceng.size() - 1) {
                    dp.addLast(first + ceng.get(j));
                } else {
                    second = dp.pollFirst();
                    dp.addLast(Math.min(first + ceng.get(j), second + ceng.get(j)));
                }
                first = second;
            }
        }
        int min = dp.get(0);
        for (Integer i : dp) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        OneTwoZero oneTwoZero = new OneTwoZero();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3, 4);
        List<Integer> row3 = Arrays.asList(6, 5, 7);
        List<Integer> row4 = Arrays.asList(4, 1, 8, 3);
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        System.out.println(oneTwoZero.minimumTotal(input));
    }
}
