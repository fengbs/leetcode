/**
 * Created by lideqing@xiaomi.com on 20-6-6
 */
public class FourSevenSevne {
    int digit[];
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        digit = new int [32];
        for (Integer i : nums) {
            computeDigit(i);
        }
        int length = nums.length;
        int sum = 0;
        for (int i = 0 ; i < digit.length ; ++i) {
            if (digit[i]!=0) {
                sum += digit[i]*(length-digit[i]);
            }
        }
        return sum;
    }

    public void computeDigit(int num) {
        int i =0;
        while (num!=0) {
            digit[i]+=num&1;
            num=num>>1;
            ++i;
        }
    }

    public static void main(String[] args) {
        FourSevenSevne fourSevenSevne = new FourSevenSevne();
        int []input = {4,14,2};
        System.out.println(fourSevenSevne.totalHammingDistance(input));
    }
}
