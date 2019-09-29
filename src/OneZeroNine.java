import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-9-18
 */
public class OneZeroNine {

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> listNodeList = new ArrayList<>();
        findLength(head,listNodeList);
        return sortedListToBST(listNodeList , 0 , listNodeList.size()-1);

    }

    private TreeNode sortedListToBST(List<ListNode> list , int start , int end) {
        int middle = start + (end - start)/2;
        TreeNode node = new TreeNode(list.get(middle).val);
        if ( middle - 1 >= start ) {
            node.left = sortedListToBST(list, start, middle - 1);
        }
        if (middle +1 <= end) {
            node.right = sortedListToBST(list,middle+1,end);
        }
        return node;
    }

    private void findLength(ListNode head,List<ListNode> list) {
        while ( head != null ) {
            list.add(head);
            head = head.next;
        }
    }

    public static void main ( String []args ) {
        OneZeroNine oneZeroNine = new OneZeroNine();
        TreeNode treeNode = oneZeroNine.sortedListToBST(CommonUtil.LinkedListFromStr("1,2,3,4,5"));
        System.out.println(treeNode.val);
    }

}
