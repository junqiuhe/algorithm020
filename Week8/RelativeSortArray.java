public class RelativeSortArray {

	/**
     * 利用计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxValue = 0;
        for (int num : arr1) {
            maxValue = Math.max(maxValue, num);
        }

        //统计每位元素的个数
        int[] bucket = new int[maxValue + 1];
        for (int num : arr1) {
            bucket[num]++;
        }

        int index = 0;
        int[] result = new int[arr1.length];
        for (int num : arr2) {
            int count = bucket[num];
            for (int j = 0; j < count; j++) {
                result[index++] = num;
            }
            bucket[num] = 0;
        }

        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            for (int j = 0; j < count; j++) {
                result[index++] = i;
            }
        }
        return result;
    }

}