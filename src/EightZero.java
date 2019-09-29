import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 19-8-26
 */
public class EightZero {
    public int removeDuplicates(int[] nums) {
        if ( nums == null || nums.length == 0 ) {
            return 0;
        }
        int curLength = 1;
        int inIndex= 1;
        for ( int i = 1 ; i < nums.length ; ++i ) {
            if ( nums[i] == nums[i-1] ) {
                ++curLength;
            } else {
                curLength = 1;
            }

            if ( curLength > 2 ) {
                continue;
            } else {
                if ( i != inIndex ) {
                    nums[inIndex] = nums[i];
                }
                ++inIndex;
            }
        }
        return inIndex;
    }
    public static void main (String []args) {
        EightZero eightZero = new EightZero();
        int []input = {1,1};
        System.out.println(eightZero.removeDuplicates(input));
        for ( int i = 0 ; i < input.length ; ++i ) {
            System.out.print(input[i] + " ");
        }
    }
}
