import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-24
 */
public class EightNine {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for ( int i = 1 ; i < n ; ++i ) {
            int length = list.size();
            for ( int j = length-1 ; j >=0 ; --j ) {
                list.add( list.get(j) + 1<<i );
            }
        }
        return list;
    }

    public static void main ( String []args ) {
        EightNine eightNine = new EightNine();
        List<Integer> list = eightNine.grayCode(2);
        for ( Integer tem : list ) {
            System.out.println(tem);
        }
    }
}
