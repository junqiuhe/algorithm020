public class MinMutation {
	/**
     * 套用 bfs 模板
     * <p>
     * 最小基因问题的本质就是，从“起始基因” 到 “终止基因” 的最短的路径的次数.
     */
    public int minMutation1(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        char[] basicChars = new char[]{'A', 'C', 'G', 'T'};

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();

                /**
                 * 依次依次变换每位字符，得到一个基因序列，
                 */
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];

                    /**
                     * 得到变换后的序列
                     */
                    for (char basicChar : basicChars) {
                        chars[i] = basicChar;
                        String next = String.valueOf(chars);

                        if (bankSet.contains(next)) {
                            if (next.equals(end)) {
                                return level + 1;
                            }

                            if (!visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                    chars[i] = oldChar;
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    /**
     * dfs
     */
    private int count = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        helper(0, start, end, bank, visited);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private void helper(int step, String start, String end, String[] bank, Set<String> visited) {
        if (start.equals(end)) {
            count = Math.min(count, step);
        }

        for (int i = 0; i < bank.length; i++) {
            String str = bank[i];
            int diff = 0;

            /**
             * 在基因库中找出存在从 start 到 基因库中的变换序列。条件是两个序列仅有一位不同.
             */
            for (int j = 0; j < start.length(); j++) {
                if (start.charAt(j) != str.charAt(j)) diff++;
                if (diff > 1) { //优化点，早点跳出循环.
                    break;
                }
            }

            /**
             * 进入下一层
             */
            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                helper(step + 1, str, end, bank, visited);
                visited.remove(str);
            }
        }
    }
}