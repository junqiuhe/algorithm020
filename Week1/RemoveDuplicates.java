
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 双指针的方式.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * list 存储不重复的数据.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(list.contains(num)){
                continue;
            }
            list.add(num);
        }
        int i = 0;
        for (Integer integer : list) {
            nums[i++] = integer;
        }
        return list.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
