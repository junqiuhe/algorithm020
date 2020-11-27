
import java.util.*;

/**
* 二叉树中序遍历
*/
class InorderTraversal {

    /**
     * 递归的方式： 二叉树中序遍历.(左-根-右)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }


    /**
     * 迭代的方式：二叉树中序遍历。
     *
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);

            root = node.right;
        }
        return list;
    }

}