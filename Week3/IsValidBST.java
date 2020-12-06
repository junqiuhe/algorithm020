public class IsValidBST {

	/**
     * 利用二叉搜索树的特性
     * <p>
     * 左子树所有节点的值小于根节点的值，右子树所有节点的值小于根节点的值。所有子树亦是如此
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if ((upper != null && root.val >= upper) || (lower != null && root.val <= lower)) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    private long preValue = Long.MIN_VALUE;

    /**
     * 利用二叉搜索树中序遍历是生序的特性.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isValid = isValidBST(root.left);
        if (!isValid) {
            return false;
        }
        if (preValue >= root.val) {
            return false;
        }
        preValue = root.val;
        return isValidBST(root.right);
    }

}