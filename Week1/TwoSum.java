
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}

//暴力，两重循环。时间复杂度 O(n^2); 空间复杂度 O(1)

//hash表，时间换空间。时间复杂度 O(n); 空间复杂度 O(n)