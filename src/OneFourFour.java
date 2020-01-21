import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-12-6
 */
public class OneFourFour {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode head = root;
        while (head != null) {
            res.add(head.val);
            if (head.right != null) {
                stack.addLast(head.right);
            }
            if (head.left !=null) {
                head = head.left;
            } else {
                if(stack.size() !=0) {
                    head = stack.pollLast();
                } else {
                    break;
                }
            }

        }
        return res;
    }

    public static void main (String []args) {
        OneFourFour oneFourFour = new OneFourFour();
        TreeNode treeNode =CommonUtil.toTree("1,null,2,null,null,3");
        CommonUtil.printList(oneFourFour.preorderTraversal(treeNode));
    }
}
