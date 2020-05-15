import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-3-27
 */
public class ThreeFiveFour {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        List<Integer> dp = new ArrayList<>();
        dp.add(envelopes[0][1]);
        for (int[] tem : envelopes) {
            if (tem[1] > dp.get(dp.size() - 1)) {
                dp.add(tem[1]);
            } else {
                dp.set(findMinMaxIndex(tem[1], dp), tem[1]);
            }
        }
        return dp.size();
    }

    private int findMinMaxIndex(int value, List<Integer> dp) {
        int start = 0;
        int end = dp.size() - 1;
        int middle = 0;
        while (start != end) {
            middle = start + (end - start) / 2;
            if (dp.get(middle) < value) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        ThreeFiveFour threeFiveFour = new ThreeFiveFour();
        int[][] a = {{2, 3}};
        System.out.println(threeFiveFour.maxEnvelopes(a));
    }

}
