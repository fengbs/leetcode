/**
 * Created by lideqing@xiaomi.com on 19-7-29
 */
public class TwoZeroZero {
	int sum = 0 ;
	boolean isUsed[][];
	int col = 0 ;
	int row = 0 ;
	void dfs (char [][] grid,int curI,int curJ) {
		if ( isIsland(grid,curI-1,curJ ) ) {
			isUsed[curI-1][curJ] = true;
			dfs(grid,curI-1,curJ);
		}
		if ( isIsland(grid,curI+1,curJ ) ) {
			isUsed[curI+1][curJ] = true;
			dfs(grid,curI+1,curJ);
		}
		if ( isIsland(grid,curI,curJ-1 ) ) {
			isUsed[curI][curJ-1] = true;
			dfs(grid,curI,curJ-1);
		}
		if ( isIsland(grid,curI,curJ+1 ) ) {
			isUsed[curI][curJ+1] = true;
			dfs(grid,curI,curJ+1);
		}
	}

	boolean isIsland( char [][] grid , int curI , int curJ ) {
		return curI >=0 && curI <col && curJ>=0 && curJ < row
			&& grid[curI][curJ] == '1' && !isUsed[curI][curJ];
	}
	public int numIslands(char [][] grid) {
		if ( grid == null || grid.length == 0 || grid[0].length == 0 ) {
			return 0;
		}
		col = grid.length;
		row = grid[0].length;

		isUsed = new boolean[grid.length][grid[0].length];
		int sum = 0 ;
		for ( int i = 0 ; i < col ; ++i ) {
			for ( int j = 0 ; j < row ; ++j ) {
				if ( !isUsed[i][j] && grid[i][j] == '1' ) {
					++sum;
					dfs(grid, i, j);
				}
			}
		}
		return sum;
	}

	public static void main ( String []args ) {
		TwoZeroZero twoZeroZero = new TwoZeroZero();
		char [][] grid = {


		};
		System.out.println(twoZeroZero.numIslands(grid));
	}
}
