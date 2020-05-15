import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-4-22
 */
public class OneFourFive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> treeNodeSet = new HashSet<>();
        Stack<TreeNode> treeNodeStack = new Stack();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                treeNodeStack.push(current);
                current = current.left;
            }
            if (treeNodeStack.size() == 0) {
                break;
            } else {
                current = treeNodeStack.peek();
                while (treeNodeSet.contains(current)) {
                    treeNodeStack.pop();
                    res.add(current.val);
                    if (treeNodeStack.size() == 0) {
                        current = null;
                        break;
                    }
                    current = treeNodeStack.peek();
                }
                if (current!=null) {
                    treeNodeSet.add(current);
                    current = current.right;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        OneFourFive oneFourFive = new OneFourFive();
        TreeNode treeNode = CommonUtil.toTree("1,2,null,null,3,null,null,null,null,4");
        CommonUtil.printList(oneFourFive.postorderTraversal(treeNode));
    }
}
