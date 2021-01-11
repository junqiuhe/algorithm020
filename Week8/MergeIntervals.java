
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];

        //按照第一列的数据大小排序.
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        for (int r = 0; r < intervals.length; r++) {
            int n1 = intervals[r][0];
            int n2 = intervals[r][1];

            if (result.size() == 0 || result.get(result.size() - 1)[1] < n1) {  //上一个区间的右边界 < 当前区间的左边界 (不相交).
                result.add(new int[]{n1, n2});
            } else {  //相交.
                int[] prev = result.get(result.size() - 1);
                prev[1] = Math.max(prev[1], n2);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

}