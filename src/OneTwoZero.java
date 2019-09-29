import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-9-29
 */
public class OneTwoZero {
    public int minimumTotal(List<List<Integer>> triangle) {
        if ( triangle == null || triangle.size() == 0 ) {
            return 0;
        }
        LinkedList<Integer> resDp = new LinkedList<>();
        int minValue = Integer.MAX_VALUE;
        for ( Integer value : resDp ) {
            if ( value < minValue ) {
                minValue = value;
            }
        }
        return minValue;
    }

    public static void main ( String []args) {
        OneTwoZero oneTwoZero = new OneTwoZero();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3,4);
        List<Integer> row3 = Arrays.asList(6,5,7);
        List<Integer> row4 = Arrays.asList(4,1,8,3);
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        System.out.println(oneTwoZero.minimumTotal(input));
    }
}
