/**
 * Created by lideqing@xiaomi.com on 20-5-23
 */
public class FourTwo {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int start = 0;
        int end = height.length-1;
        int pre = 0;
        int sum = 0;
        while (start != end) {
            int minHeight = 0;
            if (height[start] < height[end]) {
                minHeight = height[start];
                ++start;
            } else {
                minHeight = height[end];
                --end;
            }
            if (minHeight > pre) {
                pre = minHeight;
            } else {
                sum += pre - minHeight;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FourTwo fourTwo = new FourTwo();
        int []a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(fourTwo.trap(a));
    }
}
