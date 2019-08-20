import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-7-30
 */
public class FourSevenTwo {
	Set<String> set = new HashSet<>();
	boolean dfs ( String word,int current ) {
		if (  word!=null && !word.equals("")&&current == word.length() ) {
			return true;
		}
		String str = "";
		for ( int i = current ; i < word.length() ; ++i ) {
			str += word.charAt(i);
			if ( set.contains(str) ) {
				if ( dfs(word,i+1) ) {
					return true;
				}
			}
		}
		return false;
	}
	public List<String> findAllConcatenatedWordsInADict( String[] words ) {
		List<String> resList = new ArrayList<>();
		Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
		for ( String str : words ) {
			if (dfs(str,0)) {
				resList.add(str);
			}
			set.add(str);

		}
		return resList;
	}

	public static void main ( String []args ) {
		FourSevenTwo fourSevenTwo = new FourSevenTwo();
		//String []input = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		String []input = {""};
		List<String> list = fourSevenTwo.findAllConcatenatedWordsInADict(input);
		System.out.println(list.size());
		for ( int i = 0 ; i < list.size() ; ++i ) {
			System.out.println(list.get(i));
		}
	}
}
