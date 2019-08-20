import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-4-29
 */
public class OneThreeOne {
	public List<List<String>> partition(String s) {
		List<List<String>> list = new LinkedList<>();
		for ( int i = 0 ; i < s.length() ; ++i ) {

			int length = list.size();
			String currentStr = String.valueOf(s.charAt(i));
			for ( int j = 0 ; j < length ; ++j ) {
				if ( list.get(j).size() >= 2 ) {
					if ( currentStr.equals(list.get(j).get(list.get(j).size()-2)) ) {
						list.add(mergeList(list.get(j),currentStr));
					}
				}
				if ( list.get(j).size() >=1 ) {

					if ( currentStr.equals(list.get(j).get(list.get(j).size()-1)) ) {
						List<String> temList = new ArrayList<>(list.get(j));
						temList.set(temList.size()-1,currentStr+currentStr);
						list.add(temList);
					}
				}
				list.get(j).add(currentStr);

			}
			if ( list.size() == 0 ) {
				List<String> newList = new ArrayList<>();
				newList.add(currentStr);
				list.add(newList);
			}
		}
		return list;
	}

	private List<String> mergeList(List<String> strList,String str) {
		List<String> list = new ArrayList<>();
		for ( int i = 0 ; i < strList.size()-2 ; ++i ) {
			list.add(strList.get(i));
		}
		list.add(strList.get(strList.size()-2) + strList.get(strList.size()-1) + str);
		return list;
	}

	public static void main ( String []args) {
		OneThreeOne oneThreeOne = new OneThreeOne();
		List<List<String>> list = oneThreeOne.partition("abac");
		for ( List< String > strList : list ) {
			for ( String str : strList ) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}
}
