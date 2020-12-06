public class SubSets {

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        /**
         * 遍历求出每次的子集有多少位组成.
         */
        for (int i = 0; i <= nums.length; i++) {
            helper(0, 0, i, nums, new ArrayList<>(), lists);
        }
        return lists;
    }

    /**
     * 求n位元素所对应的集合.
     */
    private void helper(int level, int start, int n, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (level == n) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(level + 1, i + 1, n, nums, list, lists);
            list.remove(list.size() - 1);
        }
    }
}