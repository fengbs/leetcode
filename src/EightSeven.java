/**
 * Created by lideqing@xiaomi.com on 19-7-24
 */
public class EightSeven {
	public boolean isScramble(String s1, String s2) {
		int[] a1 = new int [26];
		int[] a2 = new int [26];
		if ( s1.equals(s2) ) {
			return true;
		}
		for ( Character c1 : s1.toCharArray() ) {
			a1[c1-'a'] += 1;
		}

		for ( Character c2 : s2.toCharArray() ) {
			a2[c2-'a'] += 1;
		}

		for ( int i = 0 ; i < 26 ; ++i) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}

		int length = s1.length();
		for ( int i = 1 ; i < length ; ++i ) {
			if ( isScramble(s1.substring(0,i),s2.substring(0,i))
				&& isScramble(s1.substring(i,length),s2.substring(i,length))
				|| isScramble(s1.substring(0,i),s2.substring(length-i,s2.length()))
					&& isScramble(s1.substring(i,length),s2.substring(0,length-i))) {
				return true;
			}
		}
		return false;
	}

	public static void main ( String []args) {
		EightSeven eightSeven = new EightSeven();
		System.out.println(eightSeven.isScramble("great","rgtae"));
	}

}
