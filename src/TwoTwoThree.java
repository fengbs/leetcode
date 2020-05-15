/**
 * Created by lideqing@xiaomi.com on 20-3-9
 */
public class TwoTwoThree {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[][] one = {{A, B}, {C, D}};
        int[][] two = {{E, F}, {G, H}};
        if (C < G) {
            int[][] tem = one;
            one = two;
            two = tem;
        }
        int row = 0;
        int col = 0;
        int sum = (one[1][0] - one[0][0]) * (one[1][1] - one[0][1]) +
            (two[1][0] - two[0][0]) * (two[1][1] - two[0][1]);
        if (two[1][0] > one[0][0]) {
            col = two[1][0] - Math.max(two[0][0],one[0][0]);
        } else {
            return sum;
        }
        if (one[1][1] >= two[1][1]) {
            if (two[1][1] > one[0][1]) {
                row = two[1][1] - Math.max(two[0][1],one[0][1]);
            } else {
                return sum;
            }
        } else {
            if (one[1][1] > two[0][1]) {
                row = one[1][1] - Math.max(two[0][1],one[0][1]);
            } else {
                return sum;
            }
        }
        return (one[1][0] - one[0][0]) * (one[1][1] - one[0][1]) +
            (two[1][0] - two[0][0]) * (two[1][1] - two[0][1]) -
            row * col;
    }

    public static void main(String[] args) {
        TwoTwoThree twoTwoThree = new TwoTwoThree();
        System.out.println(twoTwoThree.computeArea(-2,-2, 2, 2, 3, 3, 4, 4));
    }
}
