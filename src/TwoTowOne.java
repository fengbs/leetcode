/**
 * Created by lideqing@xiaomi.com on 20-3-6
 */
public class TwoTowOne {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                    if (dp[i+1][j+1] > max) {
                        max = dp[i+1][j+1];
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        TwoTowOne twoTwoOne = new TwoTowOne();
        char [][] input = {
        };
        System.out.println(twoTwoOne.maximalSquare(input));
    }
}
