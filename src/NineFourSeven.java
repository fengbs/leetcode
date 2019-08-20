import java.util.HashSet;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-3-21
 */
public class NineFourSeven {

	public static void main( String []args ) {

	}

	public static class Solution {
		private int sum = 0;
		private Set<Integer> usedSet;
		private int[] isUsedBack;
		private void dfs(int [][]stones , boolean[]isUsed,int curSum) {
			boolean flag = true;
			for ( int i = 0 ; i < stones.length ; ++i ) {
				if ( !isUsed[i] ) {
					flag = false;
					isUsed[i] = true;
					dfs(stones,isUsed,curSum+1);
					isUsed[i] = false;
				}
			}
			if (flag && sum < curSum) {
				curSum =11;
			}
		}
		public int removeStones(int[][] stones) {
			if ( stones == null || stones.length < 2 ) {
				return 0;
			}
			usedSet = new HashSet<>();
			boolean []isUsed = new boolean[stones.length];
			for ( int i = 0 ; i < stones.length ; ++i ) {
				isUsed[i] = true;
				dfs(stones,isUsed,0);
				isUsed[i] = false;
			}
			return sum;
		}
	}

}
