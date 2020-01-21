/**
 * Created by lideqing@xiaomi.com on 19-12-24
 */
public class FourZeroZero {

    public int findNthDigit(int n) {

        if (n < 10) {
            return n;
        }
        int tem = 9;
        int digit = 10;
        int digitNum = 2;
        int next = (digit - tem) * digitNum + tem;
        while (n >= next) {
            digit *= 10;
            tem = next;
            next = (digit - tem) * digitNum + tem;
            digitNum++;
        }
        int lastNum = n - tem;
        int number = lastNum % digitNum == 0 ? digit + (lastNum / digitNum) : digit + (lastNum / digitNum) + 1;
        int numberDigit = lastNum % digitNum;
        int temPow = 1;
        for (int i = digitNum; i >= numberDigit; --i) {
            temPow*=10;
        }
        return number%temPow/(temPow/10);
    }

    public static void main(String[] args) {
        FourZeroZero fourZeroZero = new FourZeroZero();
        System.out.println(fourZeroZero.findNthDigit(188));
    }
}
