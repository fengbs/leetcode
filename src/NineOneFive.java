/**
 * Created by lideqing@xiaomi.com on 19-3-22
 */
public class NineOneFive {
	public int partitionDisjoint(int[] A) {
		int []maxArr = new int[A.length];
		int []minArr = new int[A.length];
		maxArr[0] = A[0];
		minArr[A.length-1] = A[A.length-1];
		int max = A[0];
		for ( int i = 1; i < A.length ; ++i ) {
			if (A[i] > max) {
				max = A[i];
			}
			maxArr[i] = max;
		}
		int min = A[A.length-1];
		for ( int i = A.length-2 ; i >=0 ; --i ) {
			if ( A[i] < min ) {
				min = A[i];
			}
			minArr[i] = min;
		}
		int divide=0;
		for ( int i = 0 ; i < A.length-1 ; ++i ) {
			if ( maxArr[i] <= minArr[i+1] ) {
				divide = i;
				break;
			}
		}
		return divide+1;
	}


	public static void main(String []args) {
		NineOneFive nineOneFive = new NineOneFive();
		int []a = {6,0,8,30,37,6,75,98,39,90,63,74,52,92,64};
		System.out.println(nineOneFive.partitionDisjoint(a));
	}

}
