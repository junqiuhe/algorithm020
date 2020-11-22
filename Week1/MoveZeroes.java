
class Solution {

    /**
     * 两次遍历，第一次将所有非0元素往前移动，第二次将后面的数据补0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[startIndex++] = nums[i];
            }
        }

        for (int i = startIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 一次遍历
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int firstZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //swap num
                int temp = nums[firstZeroIndex];
                nums[firstZeroIndex] = nums[i];
                nums[i] = temp;

                firstZeroIndex++;
            }
        }
    }
}