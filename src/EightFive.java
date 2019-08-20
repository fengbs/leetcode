import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 19-4-30
 */
public class EightFive {
	public int maximalRectangle(char[][] matrix) {
		if ( matrix == null || matrix.length == 0 ) {
			return 0;
		}
		int row = matrix.length;
		int col = 0;
		if ( matrix[0].length > 0 ) {
			col = matrix[0].length;
		} else {
			return 0;
		}
		int max = 0 ;
		int dp[] = new int[col];
		for ( int i = 0 ; i < row ; ++i ) {
			for (int j = 0 ; j < col ; ++j) {
				if ( matrix[i][j] == '1' ) {
					dp[j] = dp[j] + 1;
				}else {
					dp[j] = 0;
				}
			}
			int tem = largestRectangleArea(dp);
			if ( tem > max ) {
				max = tem;
			}
		}
		return max;
	}
	public int largestRectangleArea(int []heights) {
		LinkedList<Integer> list = new LinkedList<>();
		int maxValue = 0;
		for ( int i = 0 ; i < heights.length ; ++i ) {
			if ( list.size() == 0 || heights[list.peekLast()] <= heights[i]) {
				list.addLast(i);
			} else {
				int preHeight = heights[list.pollLast()];
				maxValue = Math.max(maxValue,preHeight*((i -1 -(list.size()==0?-1:list.peekLast()))));
				--i;
			}

		}
		while ( list.size() != 0 ) {
			int preHeight = heights[list.pollLast()];
			maxValue = Math.max(maxValue, preHeight*(heights.length -1 - (list.size()==0?-1:list.peekLast())));
		}
		return maxValue;
	}

	public static void main (String []args) {
		EightFive eightFive = new EightFive();
		char input [][] = {{'0','1','1','0'},{'1','1','1','0'},{'1','1','1','1'},{'0','1','1','0'}};
		System.out.println(eightFive.maximalRectangle(input));
	}
}
