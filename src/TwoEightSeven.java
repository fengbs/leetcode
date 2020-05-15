/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class TwoEightSeven {
    public int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid= start + (end - start)/2;
           int count = underNum(nums,mid);
           if (count <= mid) {
               start = mid+1;
           } else {
               end = mid;
           }

        }
        return start;
    }

    int underNum(int []nums,int under) {
        int count = 0;
        for (int i = 0 ; i < nums.length ; ++i) {
            if (nums[i] <= under) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoEightSeven twoEightSeven = new TwoEightSeven();
        int []num = {3,1,3,4,2};
        System.out.println(twoEightSeven.findDuplicate(num));
    }
}
