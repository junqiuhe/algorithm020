public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
        int[] nums = new int[3]; //0：记录的是5的个数，1：记录的是10的个数，2：记录的是20的个数
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                nums[0]++;
            } else if (bills[i] == 10) {
                if (nums[0] == 0) {
                    return false;
                }
                nums[0]--;
                nums[1]++;
            } else if (bills[i] == 20) {
                if (nums[0] >= 1 && nums[1] >= 1) {
                    nums[0]--;
                    nums[1]--;
                    nums[2]++;
                } else if (nums[0] >= 3) {
                    nums[0] = nums[0] - 3;
                    nums[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

} 