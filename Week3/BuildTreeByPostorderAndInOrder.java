public class BuildTreeByPostorderAndInOrder {

	private Map<Integer, Integer> sMap = new HashMap<>();
    private int postIndex = 0;

    /**
     * postorder: 找出根节点元素.
     * inorder: 根据根节点元素确定左右子树.
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            sMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return buildTree(postorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, int iLeft, int iRight) {
        if (iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = sMap.get(root.val);

        postIndex--;

        root.right = buildTree(postorder, rootIndex + 1, iRight);
        root.left = buildTree(postorder, iLeft, rootIndex - 1);
        return root;
    }

}