/**
 * Created by lideqing@xiaomi.com on 19-12-5
 */
public class OneFiveThree {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = (end + start) / 2;
            if (nums[middle] < nums[start]) {
                end = middle;
            } else {
                if (nums[end] > nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }

        }
        return nums[middle];
    }

    public static void main(String[] args) {
        OneFiveThree oneFiveThree = new OneFiveThree();
        int[] input = {5,6,7,8,9,0,1,2,3};
        System.out.println(oneFiveThree.findMin(input));
    }
}
