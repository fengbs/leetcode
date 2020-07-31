import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-6-3
 */
public class FourZeroSix {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        int i =0;
        for (; i < people.length;++i) {
            if (people[i][1] == 0) {
                list.addLast(people[i]);
            } else {
                break;
            }
        }
        for (;i< people.length ; ++i) {
            int k = 0;
            boolean flag=false;
            Iterator<int[]> it = list.iterator();
            int j = 0;
            for (int[] tem : list) {
                if (tem[0] > people[i][0]) {
                    ++k;
                }
                if (k > people[i][1]) {
                    list.add(j,people[i]);
                    flag = true;
                    break;
                }
                ++j;
            }
            if (!flag) {
                list.addLast(people[i]);
            }

        }
        return null;
    }
}
