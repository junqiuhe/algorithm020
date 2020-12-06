public class PermuteUnique {

	/**
     * 全排列 --> 数组元素中存在重复元素
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        permute(0, new boolean[nums.length], nums, new ArrayList<>(), lists);
        return lists;
    }

    private void permute(int level, boolean[] visited, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (level == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             * 例如 1,1,2 --> 0,1,2
             *
             * (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
             *
             * 当访问数组下标1,它的前一下标为0，此时这两个下标对应的值相等，判断前一下标没有被访问过，此时就会重复1,1,2 则跳过。
             *
             */
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;

            permute(level + 1, visited, nums, list, lists);

            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}