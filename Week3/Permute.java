public class Permute {

	/**
     * 全排列 --> 数组元素中不存在重复元素
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(0, new boolean[nums.length], nums, new ArrayList<>(), lists);
        return lists;
    }

    private void permute(int level, boolean[] visited, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (level == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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