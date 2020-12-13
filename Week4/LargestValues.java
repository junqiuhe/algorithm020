public class LargestValues {

	/**
     * bfs --> 广度优先遍历，依次找出每行的最大值.
     */
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int levelCount = deque.size();
            int max = deque.peekFirst().val;
            for (int i = 0; i < levelCount; i++) {
                TreeNode curNode = deque.pollFirst();
                if (curNode.val > max) {
                    max = curNode.val;
                }
                if (curNode.left != null) {
                    deque.addLast(curNode.left);
                }
                if (curNode.right != null) {
                    deque.addLast(curNode.right);
                }
            }
            lists.add(max);
        }
        return lists;
    }

    /**
     * dfs --> 深度优先遍历，通过递归的方式
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        helper(0, root, lists);
        return lists;
    }

    /**
     * List --> index: 二叉树中的行， value: 行对应的最大值.
     */
    private void helper(int level, TreeNode root, List<Integer> lists) {
        if (root == null) {
            return;
        }

        if (level == lists.size()) {
            lists.add(root.val);
        } else {
            lists.set(level, Math.max(root.val, lists.get(level)));
        }

        helper(level + 1, root.left, lists);
        helper(level + 1, root.right, lists);
    }

}