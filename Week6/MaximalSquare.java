public class MaximalSquare {

	/**
     * dp[i][j] 状态表示 点(i, j)的最大边.
     *
     * //状态转移方程.
     * dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
     *
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        int maxSide = 0;
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][i]);
        }

        for (int j = 0; j < row; j++) {
            dp[j][0] = matrix[j][0] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide,dp[j][0]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') continue;

                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }

}