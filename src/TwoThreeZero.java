import java.util.LinkedList;

/**
 * Created by lideqing@xiaomi.com on 20-3-9
 */
public class TwoThreeZero {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode current = root;
        int num = 0;
        while (current != null || linkedList.size() != 0) {
            while (current != null) {
                linkedList.addLast(current);
                current = current.left;
            }
            if (linkedList.size() != 0) {
                TreeNode node = linkedList.pollLast();
                ++num;
                if (num == k){
                    return node.val;
                }
                current = node.right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoThreeZero twoThreeZero = new TwoThreeZero();
        TreeNode treeNode = CommonUtil.toTree("5,3,6,2,4,null,null,1");
        System.out.println(twoThreeZero.kthSmallest(treeNode,3));
    }

}
