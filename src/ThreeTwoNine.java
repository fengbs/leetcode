/**
 * Created by lideqing@xiaomi.com on 19-7-2
 */
public class ThreeTwoNine {
	int max = 0 ;
	int [][] dp;
	int col;
	int row;
	int dfs ( int [][] matrix , int curCol,  int curRow) {
		if ( dp[curCol][curRow] != 0 ) {
			return dp[curCol][curRow];
		}
		int curVal = matrix[curCol][curRow];
		int max = 0 ;
		if ( curCol != 0 && matrix[curCol-1][curRow] > curVal) {
			max = Math.max(dfs(matrix,curCol-1,curRow),max);
		}
		if ( curCol < col-1 && matrix[curCol+1][curRow] > curVal) {
			max = Math.max(dfs(matrix,curCol+1,curRow),max);
		}
		if ( curRow != 0 && matrix[curCol][curRow-1] > curVal) {
			max = Math.max(dfs(matrix,curCol,curRow-1),max);
		}
		if ( curRow < row-1 && matrix[curCol][curRow+1] > curVal) {
			max = Math.max(dfs(matrix,curCol,curRow+1),max);
		}
		max = max + 1;
		this.max = Math.max(this.max,max);
		dp[curCol][curRow] = max;
		return max;
	}
	public int longestIncreasingPath( int [][] matrix ) {
		if ( matrix == null || matrix.length == 0 ) {
			return 0;
		}
		col = matrix.length;
		row = matrix[0].length;
		dp = new int[col][row];
		for ( int i = 0 ; i < col ; ++i ) {
			for ( int j = 0 ; j < row ; ++j ) {
				dfs(matrix,i,j);
			}
		}
		return this.max;
	}

	public static void main( String [] args) {
		int matrix [][] = {{7,7,5},{2,4,6},{8,2,0}};
		ThreeTwoNine threeTwoNine = new ThreeTwoNine();
		System.out.println(threeTwoNine.longestIncreasingPath(matrix));
		for ( int [] dpArr : threeTwoNine.dp ) {
			for ( int val : dpArr ) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
}
