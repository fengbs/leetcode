public class SixThree {
    private int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid == null || obstacleGrid.length == 0|| obstacleGrid[0].length == 0 ) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        dp = new int[row][col];
        dp[0][0] = 1;
        for ( int i = 0 ; i < row ; ++i ) {
            for ( int j = 0 ; j < col ; ++j ) {
                if ( obstacleGrid[i][j] == 1 ) {
                    dp[i][j] = 0;
                    continue;
                }
                if ( i != 0 ) {
                    dp[i][j] += dp[i-1][j];
                }
                if( j != 0 ) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main ( String []args) {
        SixThree sixThree = new SixThree();
        int [][]input = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(sixThree.uniquePathsWithObstacles(input));
    }
}
