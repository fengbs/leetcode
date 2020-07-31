import java.util.Stack;

/**
 * Created by lideqing@xiaomi.com on 20-5-25
 */
public class View0504 {
    public int[] findClosedNumbers(int num) {
        int[] res = {-1, -1};
        int tem = num;
        int flagNum = -1;
        int digit = 1;
        if (num <= 0) {
            return res;
        } else if (num == 1) {
            res[0] = 2;
            return res;
        }
        int oneNum = 0;
        //find small
        while (digit <= num) {
            if ((num & digit) == 0) {
                flagNum = digit;
            } else if (flagNum != -1) {
                int other = 0;
                int temDigit = digit;
                ++oneNum;
                while (oneNum > 0) {
                    temDigit = temDigit >> 1;
                    other += temDigit;
                    oneNum--;
                }
                res[1] = ((num - digit) & (~(digit - 1))) + other + digit >> 1;
                break;
            } else {
                ++oneNum;
            }
            digit = digit << 1;
        }
        if (res[1] == -1) {
            res[1] = -1 * (num - (digit >> 1));
        }

        digit = 1;
        flagNum = -1;
        oneNum = 0;
        while (digit <= num) {
            if ((num & digit) != 0) {
                flagNum = digit;
            } else if (flagNum != -1) {
                int other = 0;
                int temDigit = 1;
                oneNum++;
                while (oneNum > 0) {
                    temDigit = temDigit << 1;
                    other += temDigit;
                    oneNum--;
                }
                res[0] = ((num + digit) & (~(digit - 1))) + other;
                break;
            } else {
                ++oneNum;
            }
            digit = digit << 1;
        }
        if (res[0] == -1 && digit != (1 << 31)) {
            res[0] = digit + num - flagNum;
        }
        return res;
    }

    public static void main(String[] args) {
        View0504 view0504 = new View0504();
        CommonUtil.printIntArr(view0504.findClosedNumbers(1837591841));
    }
}
