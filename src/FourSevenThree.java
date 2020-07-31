/**
 * Created by lideqing@xiaomi.com on 20-6-5
 */
public class FourSevenThree {

    boolean[] isUsed;
    int[] nums;
    int target = 0;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        this.nums = nums;
        isUsed = new boolean[nums.length];
        int max = 0;
        for (Integer i : nums) {
            target += i;
            if (i > max) {
                max = i;
            }
        }
        if (target == 0 || target % 4 != 0) {
            return false;
        }
        target = target / 4;
        if (target < max) {
            return false;
        }
        return dfs(0,0,0,0,0);
    }

    boolean dfs(int current, int a1, int a2, int a3, int a4) {
        if (a1 == target && a2 == target && a3 == target && a4 == target) {
            return true;
        }
        if (a1 > target || a2 > target || a3> target ||a4>target) {
            return false;
        }
        if(current == nums.length) {
            return false;
        }
        return dfs(current+1,a1+nums[current],a2,a3,a4)
            || dfs(current+1,a1,a2+nums[current],a3,a4)
            || dfs(current+1,a1,a2,a3+nums[current],a4)
            || dfs(current+1,a1,a2,a3,a4+nums[current]);
    }

    public static void main(String[] args) {
        FourSevenThree fourSevenThree = new FourSevenThree();
        int a[] = {3,3,2,4};
        System.out.println(fourSevenThree.makesquare(a));
    }
}
