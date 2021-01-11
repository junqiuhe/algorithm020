
public class IsAnagram {

	/**
     * 统计每个字符出现的次数
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];

        int length = s.length();
        for (int i = 0; i < length; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int count : map) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * 排序后组成的字符串内容是否相等.
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        return String.valueOf(sc).equals(String.valueOf(tc));
    }

}