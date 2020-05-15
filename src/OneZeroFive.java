/**
 * Created by lideqing@xiaomi.com on 20-2-17
 * // 前序遍历 preorder = [3,9,20,15,7]
 //中序遍历 inorder = [9,3,15,20,7]
 //
 */
public class OneZeroFive {

    private int preOrder[];
    private int inOrder[];
    public TreeNode dfs(int sPre , int ePre ,int sIn,int eIn) {
        if (sPre > ePre) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[sPre]);
        //find in inOrder
        int index = 0;
        for (; index <= eIn ; ++index ) {
            if (inOrder[index] == treeNode.val) {
                break;
            }
        }
        int newSEnd = sPre + index - sIn;
        treeNode.left = dfs(sPre+1,newSEnd,sIn,index-1);
        treeNode.right = dfs(newSEnd+1,ePre,index+1,eIn);
        return treeNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }
        return dfs(0,preorder.length-1,0,inorder.length-1);
    }

    public static void main(String[] args) {
        OneZeroFive oneZeroFive = new OneZeroFive();
        int pre[] = {3,9,20,15,7};
        int in[]={9,3,15,20,7};
        TreeNode node  = oneZeroFive.buildTree(pre,in);
        CommonUtil.printTree(node);
    }
}
