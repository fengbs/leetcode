/**
 * Created by lideqing@xiaomi.com on 20-6-5
 */
public class FourSevenFour {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int [][]nums = new int[strs.length][2];
        for (int i = 0 ; i < strs.length ; ++i) {
            for (Character c : strs[i].toCharArray()) {
                if (c == '1') {
                    nums[i][1]++;
                } else {
                    nums[i][0]++;
                }
            }
        }

        int [][]dp = new int[m+1][n+1];
        for (int i = 0 ; i < nums.length ; ++i) {
            for (int j = m ; j >= nums[i][0] ;--j) {
                for (int k = n; k >=nums[i][1] ; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - nums[i][0]][k - nums[i][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        FourSevenFour fourSevenFour = new FourSevenFour();
        String []arr = {"10", "0", "1"};
        System.out.println(fourSevenFour.findMaxForm(arr,1,1));
    }
}
