
public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) continue;
                minValue = Math.min(dp[i - coin] + 1, minValue);
            }
            dp[i] = minValue;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}