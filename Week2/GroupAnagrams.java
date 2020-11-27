import java.util.*;

class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> sMap = new HashMap<>();
        for (String str : strs) {
            Integer key = transform(str).hashCode();

            List<String> list = sMap.getOrDefault(key, new ArrayList<>());
            list.add(str);

            sMap.put(key, list);
        }
        return new ArrayList<>(sMap.values());
    }

    private String transform(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

}