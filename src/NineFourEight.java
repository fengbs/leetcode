import java.util.Arrays;

/**
 * Created by lideqing@xiaomi.com on 19-3-19
 */
public class NineFourEight {
	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);
		int i=0,j=tokens.length-1,point=0,res = 0;
		while (i<=j) {
			if ( P >= tokens[i] ) {
				P-=tokens[i];
				++i;
				++point;
				res = Math.max(res,point);
			} else if (point > 0) {
				P+=tokens[j];
				--j;
				--point;
			}else {
				break;
			}
		}
		return res;
	}
	public static void main ( String []args) {
		NineFourEight nineFourEight = new NineFourEight();
		int []token = {100,200,300,400};
		System.out.println(nineFourEight.bagOfTokensScore(token,200));
	}
}
