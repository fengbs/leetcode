import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 19-12-4
 */
public class OneSevenNine {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (Integer i : nums) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        OneSevenNine oneSevenNine = new OneSevenNine();
        int a[] = {0,0,0,0};
        System.out.println(oneSevenNine.largestNumber(a));
    }
}
