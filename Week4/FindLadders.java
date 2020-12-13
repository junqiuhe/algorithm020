public class FindLadders {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //存储每一层的元素
        Map<String, Set<String>> layers = new HashMap<>();
        layers.put(beginWord, new HashSet<>());

        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    dfs(beginWord, endWord, layers, new ArrayList<>(Collections.singletonList(beginWord)), result);
                    return result;
                }

                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char start = 'a'; start <= 'z'; start++) {
                        if (old == start) continue;

                        chars[i] = start;
                        String next = String.valueOf(chars);
                        if (wordSet.contains(next) && !visited.contains(next)) {
                            if (!nextLevelVisited.contains(next)) {
                                queue.offer(next);
                                nextLevelVisited.add(next);
                            }
                            layers.computeIfAbsent(cur, a -> new HashSet<>());
                            layers.get(cur).add(next);
                        }
                    }
                    chars[i] = old;
                }
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return new ArrayList<>();
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> layers, List<String> paths, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(paths));
            return;
        }

        if(!layers.containsKey(beginWord)){
            return;
        }

        Set<String> curLayer = layers.get(beginWord);
        for (String str : curLayer) {
            paths.add(str);
            dfs(str, endWord, layers, paths, result);
            paths.remove(paths.size() - 1);
        }
    }
}