public class MyPow {
    /**
     * 暴力法直接求解.
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double result = 1;
        x = n < 0 ? 1 / x : x;
        if (n < 0) {
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 分治法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        x = n < 0 ? 1 / x : x;
        if (n < 0) {
            n = -n;
        }
        return helper(x, n);
    }

    public double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = helper(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }
}