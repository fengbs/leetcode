/**
 * Created by lideqing@xiaomi.com on 20-4-8
 */
//TODO 先解决第k大的数
public class ThreeTwoFour {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int middle = findKNum(nums, 0, nums.length - 1, nums.length / 2);
        int startJi = 0;
        for (int i = 0; i < nums.length && startJi < nums.length; i++) {
            if (nums[i] < middle) {
                int tem = nums[startJi];
                nums[startJi] = nums[i];
                nums[i] = tem;
                startJi += 2;
            }
        }
        startJi = 1;
        for (int i = 0; i < nums.length && startJi < nums.length; i++) {
            if (nums[i] > middle) {
                int tem = nums[startJi];
                nums[startJi] = nums[i];
                nums[i] = tem;
                startJi += 2;
            }
        }

    }

    private int findKNum(int[] nums, int start, int end, int k) {
        int middle = partition(nums, start, end);
        if (middle == k) {
            return nums[middle];
        } else if (middle > k) {
            return findKNum(nums, start, middle - 1, k);
        } else {
            return findKNum(nums, middle + 1, end, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int tem = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tem) {
                --end;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= tem) {
                ++start;
            }
            nums[end] = nums[start];
        }
        nums[start] = tem;
        return start;
    }

    public static void main(String[] args) {
        ThreeTwoFour threeTwoFour = new ThreeTwoFour();
        int[] input = {1,1,1,2,2,2};
        threeTwoFour.wiggleSort(input);
        CommonUtil.printIntArr(input);
    }
}
