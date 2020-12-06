
public class ClimbStairs{
	
	/**
     * 加缓存的方式的复杂度
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     */
    private HashMap<Integer, Integer> sMap = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = sMap.getOrDefault(n, -1);
        if (result != -1) {
            return result;
        }
        result = climbStairs(n - 1) + climbStairs(n - 2);
        sMap.put(n, result);
        return result;
    }

}