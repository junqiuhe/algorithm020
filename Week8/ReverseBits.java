
public class ReverseBits {

	public int reverseBits(int n) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            // (n & 1) << i 依次将最后一位移动 i 位.
            result = result | ((n & 1) << i);
            n = n >> 1;
        }
        return result;
    }
}