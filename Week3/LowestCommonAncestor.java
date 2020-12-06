
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 返回其目标节点.
         */
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /**
         * 两目标节点在右子树.
         */
        if (left == null) return right;
        /**
         * 两目标节点在左子树.
         */
        if (right == null) return left;

        /**
         * 分别在其节点的左右子树，它的公共父节点就是 root.
         */
        return root;
    }

}