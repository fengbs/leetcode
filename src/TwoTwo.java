import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-15
 */
public class TwoTwo {
	List<String> res = new ArrayList<>();
	void dfs( int left,int right ,String cur ) {
		if ( left == 0 && right == 0 ) {
			res.add(cur);
			return;
		}
		if ( left != 0) {
			dfs(left-1,right,cur+ "(");
		}
		if ( right > left ) {
			dfs(left,right-1,cur+")");
		}
	}
	public List<String> generateParenthesis(int n) {
		dfs(n,n,"");
		return res;
	}

	public static void main ( String []args ) {
		TwoTwo twoTwo = new TwoTwo();
		List<String> list = twoTwo.generateParenthesis(0);
		CommonUtil.printList(list);

	}
}
