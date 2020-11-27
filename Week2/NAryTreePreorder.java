import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NAryTreePreorder{

	 /**
     * 递归的方式，N 叉树的前序遍历（根--子树）
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node item : root.children) {
            helper(item, list);
        }
    }

    /**
     * 迭代的方式. N 叉树的前序遍历（根--子树）
     * <p>
     * 利用堆栈模拟递归栈.
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);

            List<Node> childs = cur.children;
            if (childs == null || childs.size() == 0) {
                continue;
            }

            for (int i = childs.size() - 1; i >= 0; i--) {
                stack.push(childs.get(i));
            }
        }
        return list;
    }
}