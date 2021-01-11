
public class HammingWeight {

	/**
     * 依次移动一位，判断最低位是否是 1
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * n & (n - 1) --> 依次将低位的 1 变成 0
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}