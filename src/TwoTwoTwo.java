/**
 * Created by lideqing@xiaomi.com on 19-12-20
 */
public class TwoTwoTwo {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = countNodesLeftHeight(root.left);
        int rightHeight = countNodesLeftHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1<<leftHeight) + countNodes(root.right,rightHeight-1);
        } else {
            return (1<<rightHeight) + countNodes(root.left,leftHeight-1);
        }

    }

    public int countNodesLeftHeight(TreeNode root) {
        int sum = 0;
        while (root != null) {
            ++sum;
            root = root.left;
        }
        return sum;
    }

    public int countNodes(TreeNode root ,int leftHeight) {
        if (root == null) {
            return 0;
        }
        int rightHeight = countNodesLeftHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1<<leftHeight) + countNodes(root.right,rightHeight-1);
        } else {
            return (1<<rightHeight) + countNodes(root.left,leftHeight-1);
        }
    }

    public static void main(String[] args) {
        TwoTwoTwo twoTwoTwo = new TwoTwoTwo();
        TreeNode treeNode = CommonUtil.toTree("");
        System.out.println(twoTwoTwo.countNodes(treeNode));
    }
}
