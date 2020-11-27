
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NAryTreePostorder {

	/**
     * 递归的方式，N 叉树的前序遍历（根--子树）
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node item : root.children) {
            helper(item, list);
        }
        list.add(root.val);
    }

    /**
     * N叉树的后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(0, node.val);

            List<Node> childs = node.children;
            if (childs == null || childs.size() == 0) {
                continue;
            }

            for (Node child : childs) {
                stack.push(child);
            }
        }

//        Collections.reverse(list);
        return list;
    }

}