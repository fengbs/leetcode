import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-3-22
 */
public class NineNineZero {
	public static class Solution {
		private int []map = new int[26];
		public boolean equationsPossible(String[] equations) {
			for ( int i = 0 ; i < map.length ; ++i ) {
				map[i] = i;
			}
			List<String> notEquals = new LinkedList<>();
			List<Set<Character>> sets = new LinkedList<>();
			for ( String str : equations ) {
				if ( str.contains("==") ) {
					String []arr = str.split("==");
					union(arr[0].charAt(0),arr[1].charAt(0));
				} else {
					notEquals.add(str);
				}
			}
			for ( String str : notEquals ) {
				String []arr = str.split("!=");
				if (find(arr[0].charAt(0)-'a') == find(arr[1].charAt(0)-'a')) {
					return false;
				}
			}
			return true;
		}

		private int find(int x) {
			if ( map[x] == x ) {
				return x;
			}
			return map[x] = find(map[x]);
		}

		private void union(char a,char b) {

			int x = find(a-'a');
			int y = find(b-'a');
			if (map[x] != map[y]) {
				map[x] = map[y];
			}
		}
	}


	public static void main (String []args) {
		Solution s = new Solution();
		String []input = {"a==b","c==d","c==b","d!=a"};
		System.out.println(s.equationsPossible(input));
	}
}
