
/**
 * 堆排序（从小到大）
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};
        sort(arr);
        System.out.println(arr);
    }


    /**
     * 堆排序（从小到大）
     * <p>
     * 1、构建一个大顶堆.
     * 2、将大顶堆最大值移至最后一位，将剩余的元素继续构建一个大顶堆.
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        int lastIndex = arr.length - 1;

        //step1: 构建一个大顶堆.
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            buildHeap(arr, i, lastIndex);
        }

        //step2: 将大顶堆最大值移至最后一位，将剩余的元素继续构建一个大顶堆.
        int n = arr.length - 1;
        while (n >= 0) {
            swap(arr, 0, n);
            buildHeap(arr, 0, n);
            n--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int kthChild(int i, int k) {
        return i * 2 + k;
    }

    private static int maxChild(int[] arr, int i, int lastIndex) {
        int leftIndex = kthChild(i, 1);
        int rightIndex = kthChild(i, 2);
        int maxIndex = leftIndex;
        if (rightIndex < lastIndex && arr[rightIndex] > arr[leftIndex]) {
            maxIndex = rightIndex;
        }
        return maxIndex;
    }

    /**
     * @param arr
     * @param i
     */
    private static void buildHeap(int[] arr, int i, int lastIndex) {
        int value = arr[i];
        while (kthChild(i, 1) < lastIndex) {
            int child = maxChild(arr, i, lastIndex);
            if (value >= arr[child]) {
                break;
            }
            arr[i] = arr[child];
            i = child;
        }
        arr[i] = value;
    }
}