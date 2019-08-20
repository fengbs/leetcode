import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-4-26
 */
public class SevenSix {

	public String minWindow(String s, String t) {
		int[] sumOfCharT = new int[255];
		int[] sumOfCharS = new int[255];
		int numsCharT = 0;
		int numsCharS = 0;
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s
			.length()) {
			return "";
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (Character tc : t.toCharArray()) {
			int index = tc;
			sumOfCharT[index]++;
			if (sumOfCharT[index] == 1) {
				++numsCharT;
			}
		}
		int minIndex = -1, maxIndex = 1000000;
		for (int i = 0; i < s.length(); ++i) {
			int index = s.charAt(i);
			if (sumOfCharT[index] > 0) {
				sumOfCharS[index]++;
				list.add(i);

				if (sumOfCharS[index] == sumOfCharT[index]) {
					numsCharS += 1;
				}

				if (numsCharS >= numsCharT) {
					while (list.size() > 0 && sumOfCharS[s.charAt(list.get(0))] > sumOfCharT[s
						.charAt(list.get(0))]) {
						sumOfCharS[s.charAt(list.get(0))]--;
						list.pollFirst();

					}
					int temMinIndex = list.get(0);
					int temMaxIndex = list.get(list.size() - 1);
					if (temMaxIndex - temMinIndex < maxIndex - minIndex) {
						minIndex = temMinIndex;
						maxIndex = temMaxIndex;
					}
				}
			}
		}
		if (minIndex == -1) {
			return "";
		}
		return s.substring(minIndex, maxIndex + 1);
	}

	public static void main(String[] args) {
		SevenSix sevenSix = new SevenSix();
		System.out.println(sevenSix.minWindow("ADOBECODEBANC", "ABC"));
	}
}
