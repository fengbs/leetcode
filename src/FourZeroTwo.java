import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class FourZeroTwo {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> list = new LinkedList();
        if (num == null || num.length() == 0) {
            return "";
        }
        if (num.length() < k) {
            return "";
        }
        for (char a : num.toCharArray()) {
            if (list.size() == 0 || a > list.getLast() || k == 0) {
                list.addLast(a);
            } else {
                while (k > 0 && list.size() != 0 && list.getLast() > a) {
                    list.pollLast();
                    --k;
                }
                list.addLast(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean zeroFlag = true;
        for (int i = 0; i < list.size() - k; ++i) {
            if (zeroFlag && list.get(i) == '0') {
                continue;
            } else {
                sb.append(list.get(i));
                zeroFlag = false;
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FourZeroTwo fourZeroTwo = new FourZeroTwo();
        System.out.println(fourZeroTwo.removeKdigits("32134532",3));
    }
}
