
import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 19-8-16
 */
public class TwoNine {
	public int divide( int dividend , int divisor ) {
		LinkedList<Integer> temList =new LinkedList<>();

		boolean resultFlag = true;
		int res = 0;

		if ( dividend == -2147483648 && divisor == -1 ) {
			return 2147483647;
		}

		if ( dividend == -2147483648 && divisor == 1 ) {
			return -2147483648;
		}

		if ( dividend == 0 ) {
			return 0;
		}
		if ( dividend > 0 ) {
			dividend = 0 - dividend;
			if ( divisor < 0 ) {
				resultFlag = false;
			} else {
				divisor = 0 - divisor;
			}
		} else {

			if ( divisor > 0 ) {
				divisor = 0 - divisor;
				resultFlag = false;
			}
		}



		boolean pollFlag = true;
		//do main
		int resStep = 1;
		temList.addLast(divisor);
		while ( dividend <= divisor ) {
			if ( dividend <= temList.peekLast()) {
				dividend -= temList.peekLast();
				res += resStep;
				if ( pollFlag ) {
					resStep = resStep<<1;
					temList.addLast(temList.peekLast()<<1);
				}

			} else {
				pollFlag = false;
				while ( temList.size() > 0 && dividend > temList.peekLast() ) {
					temList.pollLast();
					resStep = resStep>>1;
				}
			}
		}

		//main end

		if ( !resultFlag ) {
			return 0 - res;
		}
		return res;
	}

	public static void main ( String []args ) {
		TwoNine twoNine = new TwoNine();
//		-2147483648
		System.out.println(twoNine.divide(-2147483647,-1));
	}

}
