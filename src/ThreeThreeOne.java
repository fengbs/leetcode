import java.util.Stack;

/**
 * Created by lideqing@xiaomi.com on 20-4-2
 */
public class ThreeThreeOne {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        String[] order = preorder.split(",");
        if (order[0].equals("#")) {
            if (order.length == 1) {
                return true;
            } else {
                return false;
            }
        }
        int i = 0;
        int parentNum = 0;
        while (i < order.length) {
            if (i != 0) {
                ++i;
                parentNum--;
                if (parentNum == -1 && i != order.length) {
                    return false;
                }
            }
            while (i < order.length && !order[i].equals("#")) {
                ++parentNum;
                ++i;
            }
        }
        return parentNum == -1;
    }

    public static void main(String[] args) {
        ThreeThreeOne threeThreeOne = new ThreeThreeOne();
        System.out.println(threeThreeOne.isValidSerialization("7,2,#,2,#,#,#,6,#"));
    }
}
