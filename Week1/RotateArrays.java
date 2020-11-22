class Solution {

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;

        int count = 0;
        int start = 0;

        while (count < nums.length) {
            int curIndex = start;
            int curVal = nums[start];

            do {
                /**
                 * 计算当前元素的下一个位置的下标。
                 */
                int next = (curIndex + k) % nums.length;

                /**
                 * 将下一个元素存储起来，将当前元素赋值给下一个元素。
                 */
                int temp = nums[next];
                nums[next] = curVal;

                /**
                 * 向前移动.
                 */
                curVal = temp;
                curIndex = next;
                count++;
            } while (start != curIndex);
            start++;
        }
    }

    /**
     * 1）整体反转数组，2) 、反转前k个元素，3）、反转 k ~ n之间的元素
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }

    private void helper(int[] nums, int left, int right) {
        while (left < right) {
            //swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}

//方式一、采用暴力的方式，每次移动一位元素，一共进行k次

//方式二、使用临时数组.

//方式三、循环一次，将所有元素一次性放其目标位置.

//方式四、1）整体反转数组，2) 、反转前k个元素，3）、反转 k ~ n之间的元素
