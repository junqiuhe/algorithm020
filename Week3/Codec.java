class Codec {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);
        return builder.toString().substring(0, builder.toString().length() - 1);
    }

    private void buildString(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(NN).append(spliter);
            return;
        }
        builder.append(root.val).append(spliter);
        buildString(root.left, builder);
        buildString(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(spliter)));

        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).equals(NN)) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}