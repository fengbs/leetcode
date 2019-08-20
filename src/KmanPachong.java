import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-3-14
 */
public class KmanPachong {

	public List<Integer> partForAll(String mp) {
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		int j = 0;
		for ( int i = 1 ; i < mp.length() ; ++i ) {
			if ( mp.charAt(i) == mp.charAt(j) ) {
				list.add(j++);
			} else {
				j = 0;
				list.add(-1);
			}

		}
		return list;
	}

	public boolean forMatch(String source , String match) {
		List<Integer> intList = partForAll(match);
		for ( int i = 0 ; i < intList.size() ; ++i ) {
			System.out.print(intList.get(i) + " ");
		}
		System.out.println();
		int j = 0 ;
		int i = 0;
		for (;i <source.length()&&j<match.length();) {
			if ( source.charAt(i) == match.charAt(j) ) {
				++i;
				++j;
			} else if (j == 0) {
				++i;
			} else {
				j = intList.get(j-1)+1;
			}
			//System.out.println(source.charAt(i) + " " + i + "  " + match.charAt(j) + " " + j);
			if ( match.length() == j ) {
				return true;
			}
		}
		return false;
	}

	public static void main (String []args) {
		KmanPachong kmp = new KmanPachong();
		System.out.println(kmp.forMatch("abababababababc","abababc"));
	}

}
