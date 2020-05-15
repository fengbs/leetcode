/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class TwoEightThree {
    public void moveZeroes(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length ; ++i) {
            if (nums[i] == 0) {
                distance++;
            } else if (distance!=0) {
                nums[i-distance] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        TwoEightThree twoEightSeven = new TwoEightThree();
        int [] num = {0,1,0,3,12};
        twoEightSeven.moveZeroes(num);
        CommonUtil.printIntArr(num);
    }
}
