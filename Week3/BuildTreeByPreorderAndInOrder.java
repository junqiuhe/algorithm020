public class BuildTreeByPreorderAndInOrder {

	private Map<Integer, Integer> sMap = new HashMap<>();
    private int preIndex = 0;

    /**
     * preorder: 找出根节点元素.
     * inorder: 根据根节点元素确定左右子树.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            sMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int iLeft, int iRight) {
        if (iLeft > iRight) {
            return null;
        }
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = sMap.get(rootValue);

        preIndex++;

        root.left = buildTree(preorder, iLeft, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex + 1, iRight);
        return root;
    }
}