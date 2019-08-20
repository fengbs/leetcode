import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-20
 */



public class NineThree {
    List<String> validRes = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();
    String str = null;
    void dfs( int index, int cell ) {
        if ( cell == 4 ) {
            if ( index == str.length() ) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.size(); ++i) {
                    if (i != 0) {
                        sb.append("." + temp.get(i));
                    } else {
                        sb.append(temp.get(i));
                    }
                }
                validRes.add(sb.toString());
            }
            return;
        }
        int start = str.length() -  3*(4-cell);
        if ( start < index ) {
            start = index;
        }
        for (int i = start;i < index + 3 && i < str.length() - 3 + cell ; ++i) {
            String temStr = str.substring(index,i+1);
            if ((temStr.length() < 3 || temStr.compareTo("256") == -1 )) {
                if ( temStr.length() > 1 && temStr.charAt(0) == '0' ) {
                    continue;
                }
                temp.addLast(str.substring(index, i + 1));
                dfs(i + 1, cell + 1);
                temp.pollLast();
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        str = s;
        dfs( 0, 0 );
        return validRes;
    }


    public static void main ( String []args) {
        NineThree nineThree = new NineThree();
        System.out.println(nineThree.restoreIpAddresses("172162541"));
    }
}
