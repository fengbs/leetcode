public class OneTwoNine {
    int allSum = 0;
    public void dfs(TreeNode root,int currentSum) {
        boolean isLeaf = true;
        int next = currentSum*10+root.val;
        if (root.left != null) {
            dfs(root.left,next);
            isLeaf = false;
        }
        if (root.right != null) {
            dfs(root.right,next);
            isLeaf = false;
        }
        if (isLeaf) {
            allSum+=next;
        }
    }
    public int sumNumbers(TreeNode root) {
        if (root != null) {
            dfs(root,0);
        }
        return allSum;
    }

    public static void main ( String []args) {
        OneTwoNine oneTwoNine = new OneTwoNine();
        TreeNode treeNode = CommonUtil.toTree("4,9,0,5,1");

        System.out.println(oneTwoNine.sumNumbers(treeNode));
    }
}
