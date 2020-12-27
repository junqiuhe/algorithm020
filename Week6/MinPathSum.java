public class MinPathSum {

	/**
     * 分治 + 记忆化搜索
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        return helper(0, 0, grid, new HashMap<>());
    }

    private int helper(int i, int j, int[][] grid, HashMap<String, Integer> map) {
        if (i > grid.length - 1 || j > grid[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        String key = i + "*" + j;
        if (map.containsKey(key)) return map.get(key);

        int right = helper(i, j + 1, grid, map);
        int down = helper(i + 1, j, grid, map);
        int result = Math.min(right, down) + grid[i][j];
        map.put(key, result);
        return result;
    }

    /**
     * dp[i][j]: 表示从(0,0)到(i,j)的最小路径和
     * <p>
     * dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int c = 1; c < col; c++) {  //初始化第一行
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < row; r++) {  //初始化第一列/
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

}