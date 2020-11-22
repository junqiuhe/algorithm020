
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * 采用硬编码的方式
     *
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        List<Integer> list = new ArrayList<>();
        boolean isTen = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = isTen ? digits[i] + 1 : digits[i];
            int result = num == 10 ? 0 : num;
            list.add(result);
            if (i == 0 && num == 10) {
                list.add(1);
            }
            isTen = num == 10 ? true : false;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(list.size() - 1 - i);
        }
        return arr;
    }

    /**
     * 取巧的方式
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i]++;
//            digits[i] = digits[i] % 10;
//            if (digits[i] != 0) return digits;

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDisgits = new int[digits.length + 1];
        newDisgits[0] = 1;
        return newDisgits;
    }
}


//方式一，利用整数相加

//方式二，直接采用硬编码的方式

//方式三、采用比较巧妙的方式。

/*
   思路，从后往前遍历，
   for loop
        arr[i]++; 依次加一
        arr[i] = arr[i] % 10    //取其个位数，如10，则是0
        if(arr[i] != 0){
            break;
        }
 */


