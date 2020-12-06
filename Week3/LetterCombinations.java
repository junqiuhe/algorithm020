public class LetterCombinations {

 	private static Map<Character, String> sMap = new HashMap<>();

    static {
        sMap.put('2', "abc");
        sMap.put('3', "def");
        sMap.put('4', "ghi");
        sMap.put('5', "jkl");
        sMap.put('6', "mno");
        sMap.put('7', "pqrs");
        sMap.put('8', "tuv");
        sMap.put('9', "wxyz");
    }

    /**
     * 采用回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }

        char[] chars = new char[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            chars[i] = digits.charAt(i);
        }
        letterCombinations(0, chars, new StringBuilder(), list);
        return list;
    }

    private void letterCombinations(int level, char[] chars, StringBuilder builder, List<String> list) {
        if (level == chars.length) {
            list.add(builder.toString());
            return;
        }
        String str = sMap.get(chars[level]);
        if (str == null) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            letterCombinations(level + 1, chars, builder, list);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}