
import java.util.*;

/**
* 二叉树前序
*/
class PreorderTraversal {

	/**
     * 递归的方式： 二叉树前序遍历.(根 -左 - 右)
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }


    /**
     * 迭代的方式：二叉树前序遍历。
     *
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            root = node.right;
        }
        return list;
    }
}