import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 20-5-26
 */
public class FiveOneFive {
    private List<Integer> list = new ArrayList<>();

    void dfs(TreeNode root, int cell) {
        if (list.size() < cell) {
            list.add(root.val);
        } else {
            if (list.get(cell-1) < root.val) {
                list.set(cell-1,root.val);
            }
        }
        if (root.left != null) {
            dfs(root.left, cell + 1);
        }
        if (root.right != null) {
            dfs(root.right, cell + 1);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return list;
        } else {
            dfs(root,1);
            return list;
        }
    }

    public static void main(String[] args) {
        FiveOneFive fiveOneFive = new FiveOneFive();
        System.out.println(fiveOneFive.largestValues(CommonUtil.toTree("1,3,2,5,3,null,9")));
    }
}
