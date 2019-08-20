import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 19-4-29
 */
public class EightFour {
	public int largestRectangleArea(int []heights) {
		LinkedList<Integer> list = new LinkedList<>();
		int maxValue = 0;
		for ( int i = 0 ; i < heights.length ; ++i ) {
			if ( list.size() == 0 || heights[list.peekLast()] <= heights[i]) {
				list.addLast(i);
			} else {
				int preHeight = heights[list.pollLast()];
				maxValue = Math.max(maxValue,preHeight*((i -1 -(list.size()==0?-1:list.peekLast()))));
				--i;
			}

		}
		while ( list.size() != 0 ) {
			int preHeight = heights[list.pollLast()];
			maxValue = Math.max(maxValue, preHeight*(heights.length -1 - (list.size()==0?-1:list.peekLast())));
		}
		return maxValue;
	}

	public static void main ( String []args) {
		EightFour eightFour = new EightFour();
		int []input = {9,9,9};
		System.out.println(eightFour.largestRectangleArea(input));
	}
}
