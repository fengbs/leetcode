/**
 * Created by lideqing@xiaomi.com on 20-2-28
 */
public class OneSixTwo {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        boolean leftBigger;
        boolean rightBigger;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (middle == 0) {
                leftBigger = false;
            } else {
                leftBigger = nums[middle - 1] > nums[middle];
            }
            if (middle == nums.length - 1) {
                rightBigger = false;
            } else {
                rightBigger = nums[middle + 1] > nums[middle];
            }
            if (!leftBigger && !rightBigger) {
                return middle;
            } else if (!leftBigger && rightBigger) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        OneSixTwo oneSixTwo = new OneSixTwo();
        int[] input = {1};
        System.out.println(oneSixTwo.findPeakElement(input));
    }
}
