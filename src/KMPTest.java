/**
 * Created by lideqing@xiaomi.com on 19-4-24
 */
public class KMPTest {
	public static int[] getNext(String ps) {
		char[] p = ps.toCharArray();

		int[] next = new int[p.length];

		next[0] = -1;

		int j = 0;

		int k = -1;

		while (j < p.length - 1) {

			if (k == -1 || p[j] == p[k]) {

				next[++j] = ++k;

			} else {

				k = next[k];

			}

		}

		return next;
	}

	public static void main ( String []args ) {
		String str = "asddsaasdfaf";
		int[] intList = getNext(str);
		for ( int a:intList ) {
			System.out.print(a + " ");
		}
	}
}
