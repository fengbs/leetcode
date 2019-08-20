import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lideqing@xiaomi.com on 19-3-18
 */
public class SevenZeroThree {


public static void main (String []args) {
	int [] a = {};
	KthLargest kthLargest = new KthLargest(1,a);
	System.out.println(kthLargest.add(3));   // returns 4
	System.out.println(kthLargest.add(5));   // returns 5
	System.out.println(kthLargest.add(10));  // returns 5
	System.out.println(kthLargest.add(9));   // returns 8
	System.out.println(kthLargest.add(4));   // returns 8


}

}

class KthLargest {

	private Integer k = 0;
	private PriorityQueue<Integer> minHeap;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}

		});
		for (Integer num : nums) {
			if (minHeap.size() < k) {
				minHeap.add(num);
			}else if (minHeap.peek() < num) {
				minHeap.poll();
				minHeap.add(num);
			}

		}
	}

	public int add ( int val ) {
		if (minHeap.size() >= k ) {
			if (val > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(val);
			}
		} else {
			minHeap.add(val);
		}
		return minHeap.peek();
	}

}

