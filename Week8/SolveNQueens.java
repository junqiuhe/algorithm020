public class SolveNQueens {

	public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        List<List<String>> lists = new ArrayList<>();
        dfs(chars, 0, lists);
        return lists;
    }

    private void dfs(char[][] chars, int row, List<List<String>> lists) {
        if (row >= chars.length) {
            append(chars, lists);
            return;
        }

        for (int col = 0; col < chars[row].length; col++) {
            if (isValid(chars, row, col)) {
                chars[row][col] = 'Q';
                dfs(chars, row + 1, lists);
                chars[row][col] = '.';
            }
        }
    }

    private void append(char[][] chars, List<List<String>> lists) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < chars[0].length; j++) {
                builder.append(chars[i][j]);
            }
            list.add(builder.toString());
        }
        lists.add(list);
    }

    private boolean isValid(char[][] chars, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {  //同一列
            if (chars[i][col] == 'Q') return false;
        }

        //左上角
        int r = row - 1;
        int c = col - 1;
        for (; r >= 0 && c >= 0; r--, c--) {
            if (chars[r][c] == 'Q') return false;
        }

        //右上角
        r = row - 1;
        c = col + 1;
        for (; r >= 0 && c < chars[0].length; r--, c++) {
            if (chars[r][c] == 'Q') return false;
        }
        return true;
    }

}