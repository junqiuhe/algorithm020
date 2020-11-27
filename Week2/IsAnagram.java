import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
   /**
     * 字母异位词：就是相同的字母，但是它们的位置不同
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);

            char tc = t.charAt(i);
            sMap.put(tc, sMap.getOrDefault(tc, 0) - 1);
        }

        Integer[] arr = new Integer[sMap.size()];
        sMap.values().toArray(arr);
        for (Integer i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        return String.valueOf(sc).equals(String.valueOf(tc));
    }
}

//sort --> 比较排序后的字符串是否相同.

//hash表 --> 统计两个字符串中字符出现的个数是否相同.