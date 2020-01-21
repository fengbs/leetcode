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
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> cur = new ArrayList<>(triangle.get(0));
        List<Integer> next = new ArrayList<>();
        int index = 0;
        for (int i = 1; i < triangle.size(); ++i) {
            index = 0;
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                if (j==0) {
                    next.add(triangle.get(i).get(j)+cur.get(index));
                } else if (index < cur.size()){
                    next.add(Math.min(cur.get(index-1),cur.get(index))+triangle.get(i).get(j));
                } else {
                    next.add(cur.get(index-1)+triangle.get(i).get(j));
                }
                ++index;
            }
            List tem = cur;
            cur = next;
            next = tem;
            next.clear();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < cur.size() ; ++i) {
            if (cur.get(i) < min) {
                min = cur.get(i);
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
