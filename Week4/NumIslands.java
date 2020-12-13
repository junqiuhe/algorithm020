public class NumIslands {

	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int landCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    landCount++;
//                    dfs(grid, r, c);
                    bfs(grid, r, c);
                }
            }
        }
        return landCount;
    }

    /**
     * dfs方式遍历网格
     */
    private void dfs(char[][] grid, int r, int c) {
        if (!isArea(grid, r, c)) {
            return;
        }

        if (grid[r][c] != '1') {
            return;
        }

        //表示访问过的地方
        grid[r][c] = '2';

        //遍历以 grid[r][c] 左上右下四个方向的网格
        dfs(grid, r - 1, c); //向左访问
        dfs(grid, r + 1, c); //向右访问
        dfs(grid, r, c - 1); //向上访问
        dfs(grid, r, c + 1); //向下访问
    }

    /**
     * 判断是否在网格当中.
     */
    private boolean isArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    /**
     * bfs方式遍历网络
     */
    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curNums = queue.poll();

                int row = curNums[0], col = curNums[1];
                if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                    grid[row - 1][col] = '0';   //表示已经访问过
                    queue.offer(new int[]{row - 1, col});
                }
                if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                    grid[row + 1][col] = '0';   //表示已经访问过
                    queue.offer(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                    grid[row][col - 1] = '0';   //表示已经访问过
                    queue.offer(new int[]{row, col - 1});
                }
                if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
                    grid[row][col + 1] = '0';   //表示已经访问过
                    queue.offer(new int[]{row, col + 1});
                }
            }
        }
    }

}