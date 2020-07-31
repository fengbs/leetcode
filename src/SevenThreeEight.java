/**
 * Created by lideqing@xiaomi.com on 20-7-16
 */
public class SevenThreeEight {
    public int monotoneIncreasingDigits(int N) {
        if (N == 0) {
            return 0;
        }
        int pattern = 1;
        int pre = 9;
        int tem = N;
        int index = -1;
        while (tem > 0) {
            int num = tem%10;
            if (pre < num) {
                index = pattern;
            }
            pre = num;
            tem/=10;
            pattern*=10;
        }

        if (index == -1) {
            return N;
        } else {
            int last = N/index%10;
            tem = N/index/10;
            while (tem!=0 && tem%10 == last) {
                index*=10;
                tem/=10;
            }
            return (N/index -1)*index + index -1;
        }
    }

    public static void main(String[] args) {
        SevenThreeEight sevenThreeEight = new SevenThreeEight();
        System.out.println(sevenThreeEight.monotoneIncreasingDigits(8912));
    }
}
