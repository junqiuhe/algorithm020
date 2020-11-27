
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class NAryLevelOrder {

	/**
     * N叉树层次遍历，利用队列通过迭代进行遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int curLevelSize = deque.size();

            for (int i = 0; i < curLevelSize; i++) {

                Node node = deque.pollFirst();
                if (node == null) {
                    continue;
                }

                list.add(node.val);

                for (Node child : node.children) {
                    deque.addLast(child);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 通过递归的方式.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            helper(lists, root, 0);
        }
        return lists;
    }

    private void helper(List<List<Integer>> lists, Node root, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        for (Node child : root.children) {
            helper(lists, child, level + 1);
        }
    }

}