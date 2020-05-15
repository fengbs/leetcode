/**
 * Created by lideqing@xiaomi.com on 20-3-31
 */
public class ThreeThreeSeven {
    private int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            if (isBetter(root)) {
                return root.val + dfs(root.left, false) + dfs(root.right, false);
            } else {
                int pre = root.val + dfs(root.left, false) + dfs(root.right, false);
                int after = dfs(root.left, true) + dfs(root.right, true);
                return pre > after ? pre : after;
            }
        } else {
            return dfs(root.left, true) + dfs(root.right, true);
        }
    }

    private boolean isBetter(TreeNode root) {
        int current = root.val;
        int next = 0;
        if (root.left != null) {
            next += root.left.val;
        }

        if (root.right != null) {
            next += root.right.val;
        }
        return current >= next;
    }

    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    public static void main(String[] args) {
        ThreeThreeSeven threeThreeSeven = new ThreeThreeSeven();
        TreeNode treeNode = CommonUtil.toTree("3,4,5,1,3,null,1");
        System.out.println(threeThreeSeven.rob(treeNode));
    }
}
