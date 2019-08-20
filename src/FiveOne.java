import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import sun.awt.image.ImageWatched.Link;

/**
 * Created by lideqing@xiaomi.com on 19-5-14
 */
public class FiveOne {

	private Map<Integer, Integer> rows = new HashMap<>();
	private Map<Integer, Integer> cols = new HashMap<>();
	private Map<Integer, Integer> tlitedPos = new HashMap<>();
	private Map<Integer, Integer> tlitedNeg = new HashMap<>();
	private List<LinkedList<Integer>> resList = new ArrayList<>();

	void dfs(int n, int curRow, LinkedList<Integer> points) {
		if ( curRow == n ) {
			resList.add(new LinkedList<>(points));
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (isEmpty(curRow, i)) {
				insertNode(curRow, i, points);
				dfs(n, curRow + 1, points);
				deleteNode(curRow, i, points);
			}
		}
	}

	private boolean isEmpty(int row, int col) {
		return (rows.get(row) == null || rows.get(row) == 0)
			&& (cols.get(col) == null || cols.get(col) == 0)
			&& (tlitedPos.get(col + row) == null || tlitedPos.get(col + row) == 0)
			&& (tlitedNeg.get(row - col) == null || tlitedNeg.get(row - col) == 0);
	}

	private void insertNode(int row, int col, LinkedList<Integer> points) {
		rows.put(row, getFromMap(row, rows) + 1);
		cols.put(col, getFromMap(col, cols) + 1);
		tlitedPos.put(col + row, getFromMap(row + col, tlitedPos) + 1);
		tlitedNeg.put(row - col, getFromMap(row - col, tlitedNeg) + 1);
		points.addLast(col);
	}

	private int getFromMap(int index, Map<Integer, Integer> mp) {
		Integer res = mp.get(index);
		if (res != null) {
			return res;
		}
		return 0;
	}

	private void deleteNode(int row, int col, LinkedList<Integer> points) {
		rows.put(row, getFromMap(row, rows) - 1);
		cols.put(col, getFromMap(col, cols) - 1);
		tlitedPos.put(col + row, getFromMap(col + row, tlitedPos) - 1);
		tlitedNeg.put(row - col, getFromMap(row - col, tlitedNeg) - 1);
		points.pollLast();
	}

	public List<List<String>> solveNQueens(int n) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		dfs(n, 0, linkedList);
		List<List<String>> res = new ArrayList<>();
		for ( List<Integer> list : resList ) {
			List<String> resTemList = new ArrayList<>();
			for (Integer col : list) {
				int tem = col;
				String temStr = formString( n , tem );
				resTemList.add(temStr);
			}
			res.add(resTemList);
		}
		return res;
	}

	private String formString( int n , int num ) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < n ; ++i ) {
			if ( num == i ) {
				sb.append('Q');
			} else {
				sb.append('.');
			}
		}
		return sb.toString();
	}

	public static void main ( String []args ) {
		FiveOne fiveOne = new FiveOne();
		List<List<String>> list = fiveOne.solveNQueens(4);
		for ( int i = 0 ; i < list.size() ; ++i ) {
			for ( int j = 0 ; j < list.get(i).size() ; ++j ) {
				System.out.println(list.get(i).get(j));
			}
			System.out.println("\n\n");
		}
	}
}
