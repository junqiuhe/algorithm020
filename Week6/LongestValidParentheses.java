public class LongestValidParentheses {

    /**
     * 暴力法
     */
    public int longestValidParentheses(String s) {
        int longestValidParentheses = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isValidParentHeses(subString)) {
                    longestValidParentheses = Math.max(subString.length(), longestValidParentheses);
                }
            }
        }
        return longestValidParentheses;

    }

    /**
     * 是否有效的括号.
     *
     * @param s
     * @return
     */
    private boolean isValidParentHeses(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char curValue = s.charAt(i++);
            if (curValue == '(') {
                stack.push(curValue);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}