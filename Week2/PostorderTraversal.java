
import java.util.*;

class PostorderTraversal {

	/**
     * 递归的方式： 二叉树后序遍历.(左 - 右 - 根)
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }


    /**
     * 迭代的方式：二叉树后序遍历。
     *
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (node.right == null || node.right == prev) {
                list.add(node.val);
                prev = node;
                root = null;
            } else {
                stack.push(node);
                root = node.right;
            }
        }
        return list;
    }
}