public class MajorityElement {

	/**
     * 按照题目要求，一定存在多数元素 --> Arrays.sort(nums) --> 取中间元素
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    /**
     * 采用抵消的方式.
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums.length == 0) return -1;
        int majorityElement = nums[0];
        int majorityCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                majorityCount++;
                continue;
            }
            majorityCount--;
            if (majorityCount < 0) {
                majorityCount = 0;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }

    /**
     * 采用分治算法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int calCount(int[] nums, int target, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int centerIndex = left + (right - left) / 2;
        int leftNum = helper(nums, left, centerIndex);
        int rightNum = helper(nums, centerIndex + 1, right);

        if (leftNum == rightNum) {
            return leftNum;
        }
        int lCount = calCount(nums, leftNum, left, centerIndex);
        int rCount = calCount(nums, rightNum, centerIndex + 1, right);
        return lCount > rCount ? leftNum : rightNum;
    }
}