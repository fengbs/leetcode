import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 19-8-22
 */
public class NineZero {
//    int [] nums = null;
//    LinkedList<Integer> oneList = new LinkedList<>();
//    List<List<Integer>> res = new LinkedList<>();
//    void dfs(int start) {
//        Set<Integer> set = new HashSet<>();
//        for ( int i = start+1 ; i < nums.length ; ++i ) {
//            if ( set.contains(nums[i])) {
//                continue;
//            }
//            oneList.addLast(nums[i]);
//            res.add(new ArrayList<>(oneList));
//            dfs(i);
//            oneList.pollLast();
//        }
//    }
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        this.nums = nums;
//        Set<Integer> set = new HashSet<>();
//        for ( int i = 0 ; i < nums.length ; ++i ) {
//            if ( set.contains(nums[i])) {
//                continue;
//            }
//            set.add(nums[i]);
//            oneList.add(nums[i]);
//            res.add(new ArrayList<>(oneList));
//            dfs(i);
//            oneList.pollLast();
//        }
//        return res;
//    }


    int [] nums = null;
    LinkedList<Integer> oneList = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    void dfs(int start) {
        for ( int i = start+1 ; i < nums.length ; ++i ) {
            if ( i!= start+1 && nums[i] == nums[i-1]) {
                continue;
            }
            oneList.addLast(nums[i]);
            res.add(new ArrayList<>(oneList));
            dfs(i);
            oneList.pollLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        for ( int i = 0 ; i < nums.length ; ++i ) {
            if ( i!= 0 && nums[i] == nums[i-1]) {
                continue;
            }
            oneList.add(nums[i]);
            res.add(new ArrayList<>(oneList));
            dfs(i);
            oneList.pollLast();
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    public static void main(String[] args) {
        NineZero nineZero = new NineZero();
        int input[] = {4,4,1,4};
        List<List<Integer>> list = nineZero.subsetsWithDup(input);
        CommonUtil.printList2(list);
        System.out.println(list.size());
    }
}
