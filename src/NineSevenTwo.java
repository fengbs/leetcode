/**
 * Created by lideqing@xiaomi.com on 19-3-26
 */
public class NineSevenTwo {
	class IntegerPart {
		String int_part;
		String np_part;
		String re_part;
	}
	public boolean isRationalEqual(String S, String T) {
		IntegerPart intS = splitToInteger(S);
		IntegerPart intT = splitToInteger(T);
		return  false;

	}

	private void dealWithIntegerPart(IntegerPart integerPart) {
		if ( integerPart.re_part !=null ) {
			for (int i = 0; i < integerPart.re_part.length(); ++i) {

			}
		}
	}

	private IntegerPart splitToInteger(String s) {
		IntegerPart integerPart = new IntegerPart();
		if (s == null) {
			return integerPart;
		}
		String []s_str = s.split(".");
		if ( s_str.length > 0 ) {
			integerPart.int_part = s_str[0];
			if (s_str.length > 1) {
				if (s_str[1].contains("(")) {
					String []new_str = s_str[1].split("(|)");
					if ( new_str.length > 1 ) {
						integerPart.np_part = new_str[0];
						integerPart.re_part = new_str[1];
					} else {
						integerPart.re_part = new_str[0];
					}
				} else {
					integerPart.np_part = s_str[1];
				}
			}
		}
		return integerPart;
	}
	public static void main(String []args) {
		NineSevenTwo nineSevenTwo = new NineSevenTwo();

	}
}


