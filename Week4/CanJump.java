public class CanJump {

	public boolean canJump(int[] nums) {
        int k = 0;  //每个格子能够跳跃最大格子数的最大值.
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;  //如果数组的下标大于了最大值，说明跳不过最后一步了.
            k = Math.max(k, i + nums[i]);
        }
        return true;

        // return helper(0, nums);
    }

    //方式一、采用递归的解决方案.
    private boolean helper(int level, int[] nums) {
        if (level >= nums.length - 1) {
            return true;
        }

        int step = nums[level];
        for (int i = step; i > 0; i--) {
            boolean canJump = helper(level + i, nums);
            if (canJump) {
                return true;
            }
        }
        return false;
    }

}