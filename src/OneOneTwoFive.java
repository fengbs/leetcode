import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-7-29
 */
public class OneOneTwoFive {

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		int length = people.size();
		int[] digitPeople = new int[length];
		Map<Integer, List<Integer>> res = new HashMap<>();
		Map<String, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < req_skills.length; ++i) {
			indexMap.put(req_skills[i], i);
		}
		for (int i = 0; i < people.size(); ++i) {
			for ( String str : people.get(i) ) {
				digitPeople[i] |= 1<<indexMap.get(str);
			}
		}
		for (int i = 0; i < digitPeople.length; ++i) {
			if (digitPeople[i] != 0) {
				if (res.size() == 0) {
					List<Integer> resList = new ArrayList<>();
					resList.add(i);
					res.put(digitPeople[i], resList);
				} else {
					Set<Integer> set = new HashSet<>(res.keySet());
					for (Integer key : set) {
						int sum = key | digitPeople[i];
						if (res.get(sum) == null
							|| res.get(sum).size() > res.get(key).size() + 1) {
							List<Integer> resList = new ArrayList<>(res.get(key));
							resList.add(i);
							res.put(sum, resList);
						}
					}
					List<Integer> resList = new ArrayList<>();
					resList.add(i);
					res.put(digitPeople[i],resList);
				}
			}
		}
		List<Integer> resList = res.get((1 << req_skills.length) - 1);
		int[] a = new int[resList.size()];
		for (int i = 0; i < resList.size(); ++i) {
			a[i] = resList.get(i);
		}
		return a;
	}

	public static void main(String[] args) {
		OneOneTwoFive oneOneTwoFive = new OneOneTwoFive();

		String[] skill = {"algorithms","math","java","reactjs","csharp","aws"};
		String[][] list = {{"algorithms","math","java"},{"algorithms","math","reactjs"},{"java","csharp","aws"},{"reactjs","csharp"},{"csharp","math"},{"aws","java"}};
		List<List<String>> allList = new ArrayList<>();
		for (String[] tem : list) {
			allList.add(Arrays.asList(tem));
		}
		int[] res = oneOneTwoFive.smallestSufficientTeam(skill, allList);
		for (int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}
	}

}
