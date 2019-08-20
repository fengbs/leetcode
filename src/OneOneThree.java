import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-20
 */
public class OneOneThree {
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int target = 0;
    public void dfs(TreeNode root,int sum) {
        int k = 0;
        sum += root.val;
        list.add(root.val);
        if ( root.left != null ) {
            ++k;
            dfs(root.left,sum);
        }
        if ( root.right != null ){
            ++k;
            dfs(root.right,sum);
        }
        if ( k == 0 ) {
            if ( sum == target ) {
                res.add(new ArrayList<>(list));
            }
        }
        list.removeLast();

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        if ( root == null ) {
            return res;
        }
        dfs(root,0);
        return res;
    }

    public static void main ( String []args) {
        OneOneThree oneOneThree = new OneOneThree();
        TreeNode input = CommonUtil.toTree("5,4,8,11,null,13,4,7,2,null,null,null,null,5,1");
        CommonUtil.printList2(oneOneThree.pathSum(input,22));
    }
}
