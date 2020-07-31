/**
 * Created by lideqing@xiaomi.com on 20-6-2
 */
public class ThreeNineSix {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0 ; i < A.length ; ++i) {
            sum += A[i];
        }
        int origin = 0;
        for (int i = 0 ; i < A.length ; ++i) {
            origin += i*A[i];
        }
        int max = origin;
        for (int i = 1 ; i < A.length ; ++i) {
            origin = origin - sum + A[i-1] * (A.length);
            if (origin > max) {
                max = origin;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ThreeNineSix threeNineSix = new ThreeNineSix();
        int a[] = {4, 3, 2, 6};
        System.out.println(threeNineSix.maxRotateFunction(a));
    }
}
