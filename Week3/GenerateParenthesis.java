public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
//        generateParenthesis(n * 2, "", list);
//        generateParenthesis(0, 0, n, "", list);
        generateParenthesis(0, 0, n, new StringBuilder(), list);
        return list;
    }

    /**
     * 方式一，step1：列举生成括号的所有情况；step2：在生成的所有括号序列中找出合法的.
     *
     * @param level
     * @param result
     * @param list
     */
    public void generateParenthesis(int level, String result, List<String> list) {
        if (level == 0) {
            if (isValid(result)) list.add(result);
            return;
        }
        generateParenthesis(level - 1, result + "(", list);
        generateParenthesis(level - 1, result + ")", list);
    }

    private boolean isValid(String result) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    /**
     * 方式二，在生成括号的过程中，去掉不合法括号的情况.
     *
     * @param left
     * @param right
     * @param n
     * @param result
     * @param list
     */
    public void generateParenthesis(int left, int right, int n, String result, List<String> list) {
        if (left == n && right == n) {
            list.add(result);
            return;
        }
        if (left < n) generateParenthesis(left + 1, right, n, result + "(", list);
        if (right < left) generateParenthesis(left, right + 1, n, result + ")", list);
    }

    /**
     * 避免在递归调用过程中，频繁的创建String对象.
     *
     * @param left
     * @param right
     * @param n
     * @param builder
     * @param list
     */
    public void generateParenthesis(int left, int right, int n, StringBuilder builder, List<String> list) {
        if (left == n && right == n) {
            list.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            generateParenthesis(left + 1, right, n, builder, list);
            builder.deleteCharAt(builder.length() - 1); //reverse current level state.
        }
        if (right < left) {
            builder.append(")");
            generateParenthesis(left, right + 1, n, builder, list);
            builder.deleteCharAt(builder.length() - 1); //reverse current level state.
        }
    }
    
}