import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-7-25
 */
//not solve
public class OneTwoSix {
	List<List<String>> path = new LinkedList<>();
	int minTrans = 0 ;
	int used[];
	public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
		minTrans = wordList.size()+10;
		if ( wordList == null || !wordList.contains(endWord) ) {
			return path;
		}
		used = new int[wordList.size()];
		LinkedList<String> res = new LinkedList<>();
		res.addLast(beginWord);
		dfs(beginWord,endWord,wordList,res,0);
		return path;
	}

	public void dfs(String beginWord,String endWord,List<String> wordList,LinkedList<String> res,int pathNum) {
		if ( pathNum > minTrans ) {
			return;
		} else {
			if ( pathNum == minTrans && !beginWord.equals(endWord)) {
				return;
			}
		}
		if ( beginWord.equals(endWord) ) {
			if ( pathNum == minTrans ) {
				path.add(new LinkedList<>(res));
			} else if ( pathNum < minTrans ) {
				path.clear();
				path.add(new LinkedList<>(res));
				minTrans = pathNum;
			}
		}
		for ( int i = 0 ; i < wordList.size(); ++i ) {
			if ( used[i] == 0 && isDiffInOneWord(beginWord,wordList.get(i)) ) {
				res.addLast(wordList.get(i));
				used[i] = 1;
				dfs(wordList.get(i),endWord,wordList,res,pathNum+1);
				res.pollLast();
				used[i] = 0 ;
			}
		}
	}
	public boolean isDiffInOneWord(String origin,String other) {
		int sum = 0;
		for ( int i = 0 ; i < origin.length() ; ++i ) {
			if ( origin.charAt(i) != other.charAt(i) ) {
				++sum;
			}
		}
		return sum == 1;
	}

	public static void main ( String []args ) {
		OneTwoSix oneTwoSix = new OneTwoSix();
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		List<List<String>>  path = oneTwoSix.findLadders("hit","cog",wordList);
		for ( List<String> strings : path ) {
			for ( String str : strings ) {
				System.out.print(str+",");
			}
			System.out.println();
		}
	}
}
