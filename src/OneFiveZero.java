import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 19-12-5
 */
public class OneFiveZero {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        int a = 0;
        int b = 0;
        for (String str : tokens) {
            if ("+".equals(str)) {
                a = list.pollLast();
                b = list.pollLast();
                list.addLast(a + b);
            } else if ("-".equals(str)) {
                a = list.pollLast();
                b = list.pollLast();
                list.addLast(b - a);
            } else if ("*".equals(str)) {
                a = list.pollLast();
                b = list.pollLast();
                list.addLast(a * b);
            } else if ("/".equals(str)) {
                a = list.pollLast();
                b = list.pollLast();
                list.addLast(b / a);
            } else {
                list.addLast(Integer.parseInt(str));
            }

        }
        return list.get(0);
    }

    public static void main(String[] args) {
        OneFiveZero oneFiveZero = new OneFiveZero();
        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(oneFiveZero.evalRPN(arr));
    }
}
