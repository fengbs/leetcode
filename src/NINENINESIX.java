import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 19-3-15
 */
public class NINENINESIX {
	private int sum=0;
	public void dfs (int[]A,boolean []flag,int addNum,int preNum) {
		if ( addNum == A.length ) {
			++sum;
			return;
		}
		int pre = -1;
		for ( int i = 0 ; i < A.length ; ++i ) {
			if ( flag[i] || pre == A[i] ) {
				continue;
			}
			double sqrtNum = Math.sqrt(A[i] + preNum);
			if ( sqrtNum == (int)sqrtNum ) {
				flag[i] = true;
				dfs(A, flag, addNum + 1, A[i]);
				flag[i] = false;
			}
			pre = A[i];
		}
	}

	public int numSquarefulPerms( int[] A ) {
		this.sum = 0 ;
		Arrays.sort(A);
		boolean []flag = new boolean[A.length];
		int pre = -1;
		for ( int i = 0 ; i < A.length ; ++i ) {
			if ( A[i] == pre ) {
				continue;
			}
			flag[i] = true;
			dfs(A,flag,1,A[i]);
			flag[i] = false;
			pre = A[i];
		}
		return sum;
	}

	public static void main (String []args) {
		NINENINESIX nns = new NINENINESIX();
		int[] input = {2,2,2};
		System.out.println(nns.numSquarefulPerms(input));
	}
}
