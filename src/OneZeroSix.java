/**
 * Created by lideqing@xiaomi.com on 19-8-19
 */
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
public class OneZeroSix {
    int [] inorder = null;
    int [] postorder = null;
    int postIndex = 0;

    TreeNode buildTreeByMiddle (int start,int end,int endPost) {
        TreeNode treeNode = new TreeNode(postorder[endPost]);
        if ( start == end ) {
            return treeNode;
        }
        int i;
        for ( i = start ; i <= end ; ++i ) {
            if (treeNode.val == inorder[i]) {
                break;
            }
        }
        int rightLength = end - i;
        if ( i != start ) {
            --postIndex;
            treeNode.left = buildTreeByMiddle(start,i-1,endPost-rightLength-1);
        }
        if ( i != end ) {
            --postIndex;
            treeNode.right = buildTreeByMiddle(i+1,end,endPost-1);
        }
        return treeNode;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ( inorder.length == 0 ) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        return buildTreeByMiddle(0,inorder.length-1,postorder.length-1);

    }

    public static void main ( String []args ) {
        OneZeroSix oneZeroSix = new OneZeroSix();
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        TreeNode treeNode = oneZeroSix.buildTree(inorder,postorder);
        System.out.println(treeNode);

    }
}
