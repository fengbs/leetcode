import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 19-12-3
 */
public class OneEightSeven {

    private final int mod = (1 << 18) - 1;

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if (s.length() < 10) {
            return res;
        }
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < 10; ++i) {
            sum = (sum << 2) + mapValue(s.charAt(i));
            sb.append(s.charAt(i));
        }
        map.put(sum, sb.toString());
        for (int i = 10; i < s.length(); ++i) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            sum = ((sum & mod) << 2) + mapValue(s.charAt(i));
            if (map.containsKey(sum)) {
                if (!"".equals(map.get(sum))) {
                    res.add(map.get(sum));
                    map.put(sum,"");
                }
            } else {
                map.put(sum, sb.toString());
            }
        }

        return res;
    }

    public int mapValue(char s) {
        switch (s) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        OneEightSeven oneEightSeven = new OneEightSeven();
        CommonUtil.printList(oneEightSeven.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
