public class Combine {

	/**
	* 组合
	*/
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    private void combine(int start, int n, int k, List<Integer> list, List<List<Integer>> lists) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

//        for (int i = start; i <= n; i++) {
        for (int i = start; i <= n - k + 1; i++) { //n - k + 1，减去不可能存在的情况.
            list.add(i);
            combine(i + 1, n, k - 1, list, lists);
            list.remove(list.size() - 1);
        }
    }

}