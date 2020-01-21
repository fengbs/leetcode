/**
 * Created by lideqing@xiaomi.com on 19-12-5
 */
public class OneFiveTwo {
    public int maxProduct(int[] nums) {
        int resMax = nums[0];
        int currentMax = 1;
        int currentMin = 1;
        for (int i = 0; i < nums.length; ++i) {
            int temMax = currentMax;
            int temMin = currentMin;
            if (nums[i] > 0) {
                if (temMin < 0) {
                    currentMin = temMin * nums[i];
                } else {
                    currentMin = nums[i];
                }

                if (temMax > 0) {
                    currentMax = temMax * nums[i];
                } else {
                    currentMax = nums[i];
                }

            } else if (nums[i] < 0) {
                if (temMin < 0) {
                    currentMax = temMin * nums[i];
                } else {
                    currentMax = nums[i];
                }
                if (temMax > 0) {
                    currentMin = temMax * nums[i];
                } else {
                    currentMin = nums[i];
                }
            } else {
                currentMax = 0;
                currentMin = 0;
            }
            if (currentMax > resMax) {
                resMax = currentMax;
            }


        }
        return resMax;
    }

    public static void main(String[] args) {
        OneFiveTwo oneFiveTwo = new OneFiveTwo();
        int[] input = {-2};
        System.out.println(oneFiveTwo.maxProduct(input));
    }
}