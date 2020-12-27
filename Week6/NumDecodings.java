public class NumDecodings {

	/**
     * 参考: https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
     */
    public int numDecodings(String s) {
        return helper(0, s, new HashMap<>());
    }

    /**
     * 递归 + 记忆化搜索
     */
    private int helper(int start, String s, HashMap<Integer, Integer> smap) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;

        int res = smap.getOrDefault(start, -1);
        if (res != -1) return res;

        int answer1 = helper(start + 1, s, smap);
        int answer2 = 0;
        if (start + 1 < s.length()) {
            String result = s.substring(start, start + 2);
            if (Integer.parseInt(result) <= 26) {
                answer2 = helper(start + 2, s, smap);
            }
        }

        res = answer1 + answer2;

        smap.put(start, res);

        return res;
    }

    /**
     * 动态规划。
     */
    private int dp(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            String result = s.substring(i, i + 2);
            dp[i] = Integer.parseInt(result) > 26 ? dp[i + 1] : dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

}