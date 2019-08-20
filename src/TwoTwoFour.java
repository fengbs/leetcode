import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 19-7-26
 */
public class TwoTwoFour {
	public int calculate(String s) {
		LinkedList<Character> operators = new LinkedList<>();
		int bracketSign = 1;
		int currentSign = 1;
		char preOperator = '+';
		int sum = 0 ;
		s=s.replace(" ","");
		for ( int i = 0 ; i < s.length() ; ++i ) {

			int curNum = 0;
			while ( i < s.length() && '0' <= s.charAt(i)  && s.charAt(i) <= '9') {
				curNum =  curNum * 10 + (s.charAt(i)-'0');
				++i;
			}
			sum += bracketSign * currentSign * curNum;
			System.out.println(" " + (bracketSign * currentSign * curNum));
			if ( i >= s.length() ) {
				return sum;
			}
			char cur = s.charAt(i);
			if ( cur == '(' ) {
				if ( preOperator == '-' ) {
					bracketSign*=-1;
					currentSign = 1;
				}
				operators.addLast(preOperator);
			} else if ( cur == ')') {
				Character curOp = operators.pollLast();
				if ( curOp == '-' ) {
					bracketSign*=-1;
					currentSign = 1;
				}

			} else if ( cur == '-' ) {
				preOperator = '-';
				currentSign = -1;
			} else {
				preOperator = '+';
				currentSign = 1;
			}
		}
		return sum;

	}

	public static void main ( String []args) {
		TwoTwoFour twoTwoFour = new TwoTwoFour();
		System.out.println(twoTwoFour.calculate("121 + 1 - ( 123 + 1)"));
	}

}
