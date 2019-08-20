/**
 * Created by lideqing@xiaomi.com on 19-3-15
 */
public class OneThousand {
	public int mergeStones(int [] stones,int k) {
		if ( (stones.length - 1)%(k-1) != 0 ) {
			return -1;
		}

		int length = stones.length;
		while ( k < length ) {
			for (int i = k; i < stones.length; ++i) {

			}
		}
		return 0;

	}
}
