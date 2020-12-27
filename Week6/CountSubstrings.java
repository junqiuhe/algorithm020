public class CountSubstrings {

	/**
     * 暴力法
     */
    public int countSubstrings1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


    /**
     *
     * https://leetcode-cn.com/problems/palindromic-substrings/solution/shou-hua-tu-jie-dong-tai-gui-hua-si-lu-by-hyj8/
     *
     * dp
     *
     * dp[i, j] 表示是否是回文串.
     *
     * 1、单个字符串是回文串
     * 2、两个字符，且字符相同 --> 回文串
     * 3、超过两个字符，首尾字符相同且除去首字符的剩余子串也是回文.
     */
    public int countSubstrings2(String str) {
        int count = 0;

        char[] s = str.toCharArray();
        int n = s.length;

        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {   // 单个字符的情况
                    dp[i][j] = true;
                    count++;
                } else if (j - i == 1 && s[i] == s[j]) { //两个字符的情况
                    dp[i][j] = true;
                    count++;

                    /**
                     * s[i] == s[j] --> 首尾字符相同
                     * dp[i + 1][j - 1]  --> 除去首字符，剩余子串是否是回文串.
                     */
                } else if (j - i > 1 && s[i] == s[j] && dp[i + 1][j - 1]) { // 多于两个字符
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 中心拓展法
     * https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-by-leetcode-solution/553051/
     */
    public int countSubstrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) { //遍历回文中心点

            for (int j = 0; j <= 1; j++) { //j=0,中心是一个点，j=1,中心是两个点
                int left = i;
                int right = i + j;

                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                    count++;
                    left--;
                    right++;
                }
            }
        }
        return count;
    }

}