
import java.util.Arrays;

class Solution {

    //方式一、将num2的数据copy到num1中，然后排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //方式二、从后向前比较，将较大的数据从后往前放。
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;

        int r1 = m - 1;
        int r2 = n - 1;

//        while (r1 >= 0 && r2 >= 0) {
//            while (r1 >= 0 && nums1[r1] > nums2[r2]) {
//                nums1[index--] = nums1[r1--];
//            }
//            while (r1 >= 0 && r2 >= 0 && nums1[r1] <= nums2[r2]) {
//                nums1[index--] = nums2[r2--];
//            }
//        }

        //优化后的代码.
        while (r1 >= 0 && r2 >= 0) {
            nums1[index--] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
        }

        //此处可以省略，因此本身就在num1数组上操作.
        // while (r1 >= 0) {
        //     nums1[index--] = nums1[r1--];
        // }

        while (r2 >= 0) {
            nums1[index--] = nums2[r2--];
        }
    }

    //最优的代码.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;

        int r1 = m - 1;
        int r2 = n - 1;

        while (r1 >= 0 && r2 >= 0) {
            nums1[index--] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
        }
        while (r2 >= 0) {
            nums1[index--] = nums2[r2--];
        }
    }
}

//方式一、将num2的数据copy到num1中，然后排序

//方式二、从后向前比较，将较大的数据从后往前放。