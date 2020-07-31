/**
 * Created by lideqing@xiaomi.com on 20-5-18
 */
public class Eleven {
    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start != end) {
            int sum;
            if (height[start] > height[end]) {
                sum = height[end] * (end - start);
                --end;
            } else {
                sum = height[start] * (end - start);
                ++start;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Eleven eleven = new Eleven();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(eleven.maxArea(input));
    }
}
