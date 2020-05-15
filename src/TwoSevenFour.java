import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 20-3-27
 */
public class TwoSevenFour {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for (int i = citations.length-1 ; i >=0 ; --i) {
            if (citations[i] >= (citations.length-i)) {
                res = citations.length-i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSevenFour twoSevenFour = new TwoSevenFour();
        int []input = {4,0,6,1,5};
        System.out.println(twoSevenFour.hIndex(input));
    }
}
