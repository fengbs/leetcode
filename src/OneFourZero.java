import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-8-1
 */
public class OneFourZero {
	List<String> []dp;
	Set<String> set = new HashSet<>();
	List<String> dfs ( String s,int current) {
		List<String> singleRes = new ArrayList<>();
		List<String> temArr = dp[current];
		String temS ="";
		if ( temArr == null ) {
			for (int i = current; i < s.length(); ++i) {
				temS += s.charAt(i);
				if (set.contains(temS)) {
					if (i == s.length() - 1) {
						singleRes.add(temS);
					} else {
						List<String> temRes = dfs(s, i + 1);
						for (String str : temRes) {
							singleRes.add(temS+" " + str);
						}
					}
				}

			}
		} else {
			return dp[current];
		}
		dp[current] = singleRes;
		return singleRes;
	}

	public List<String> wordBreak( String s, List<String> wordDict ) {
		if ( s == null ) {
			return null;
		}
		for ( int i = 0 ; i < wordDict.size() ; ++i ) {
			set.add(wordDict.get(i));
		}
		dp = new List[s.length()];
		List<String> res = dfs ( s,0);
		return res;
	}

	public static void main (String []args) {
		OneFourZero oneFourZero = new OneFourZero();
		List<String> input = new ArrayList<>();
		input.add("cat");
		input.add("cats");
		input.add("and");
		input.add("sand");
		input.add("dog");
		System.out.println(oneFourZero.wordBreak("catsanddog",input));
	}

}
