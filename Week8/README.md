#### 一、初级排序算法

##### 1.1）、选择排序

每次找最小值，然后放到待排序数组的起始位置.

```
//时间复杂度: O(n^2)， 空间复杂度: O(1)
/**
 * 每次选择最小值，然后将其放入待排序序列的起始位置
 */
public void selectSort(int[] arrays) {
    if (arrays == null || arrays.length == 0) return;
    for (int i = 0; i < arrays.length; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arrays.length; j++) {
            if (arrays[j] < arrays[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            int t = arrays[i];
            arrays[i] = arrays[minIndex];
            arrays[minIndex] = t;
        }
    }
}
```

##### 1.2）、插入排序

通过构建有序序列，对于未排序的数据，在已排序序列中从后往前扫描，找到相应的位置并插入

```
public void insertSort(int[] arrays) {
    if (arrays == null || arrays.length == 0) return;

    for (int i = 1; i < arrays.length; i++) {
        int insertValue = arrays[i];
        int insertIndex = i;
        for (int j = i - 1; j >= 0; j--) {
            if (arrays[j] < insertValue) {
                break;
            }
            arrays[j + 1] = arrays[j];
            insertIndex--;
        }

        if (insertIndex != i) {
            arrays[insertIndex] = insertValue;
        }
    }
}
```

##### 1.3）、冒泡排序

嵌套循环，每次两两比较，如果是逆序，则两两交换。结果就是每一轮比较后，最大值/最小值将会冒泡到最后。

```
public void bubbleSort(int[] arrays) {
    if (arrays == null || arrays.length == 0) return;

    for (int i = 0; i < arrays.length; i++) {
        for (int j = 0; j < arrays.length - i - 1; j++) {
            if (arrays[j] > arrays[j + 1]) {
                int t = arrays[j];
                arrays[j] = arrays[j + 1];
                arrays[j + 1] = t;
            }
        }
    }
}
```

#### 二、高级排序算法

##### 2.1）、快速排序

数组取标杆pivot, 将小元素放pivot左边，大元素放右侧，然后依次对左侧和右侧的子数组继续快排；以达到整个序列有序

```
public void quickSort(int[] arrays) {
    quickSort(arrays, 0, arrays.length - 1);
}

private void quickSort(int[] arrays, int left, int right) {
    if (left >= right) {
        return;
    }
    int partition = partition(arrays, left, right);
    quickSort(arrays, left, partition - 1);
    quickSort(arrays, partition + 1, right);
}

private int partition(int[] arrays, int left, int right) {
    int pivot = left;
    int counter = pivot + 1;  //
    for (int i = counter; i <= right; i++) {
        if (arrays[i] < arrays[pivot]) {
            swap(arrays, i, counter);
            counter++;
        }
    }
    swap(arrays, pivot, counter - 1);
    return counter - 1;
}

private void swap(int[] arrays, int i, int j) {
    int t = arrays[i];
    arrays[i] = arrays[j];
    arrays[j] = t;
}
```

##### 2.2）、归并排序 --> 分治的思想

核心思想：将两个排序好的子序列合并成一个较大的排序序列，依次类推，最终得到有序的序列.

```
public void merge(int[] arrays) {
    mergeSort(arrays, 0, arrays.length - 1);
}

private void mergeSort(int[] arrays, int start, int end) {
    if (start >= end) return;

    int mid = start + (end - start) / 2;
    mergeSort(arrays, start, mid);
    mergeSort(arrays, mid + 1, end);

    merge(arrays, start, mid, end);
}

/**
 * 合并两个有序的子序列.
 */
private void merge(int[] arrays, int start, int mid, int end) {
    int[] arr = new int[end - start + 1];

    int i = 0, l1 = start, l2 = mid + 1;

    while (l1 <= mid && l2 <= end) {
        arr[i++] = arrays[l1] < arrays[l2] ? arrays[l1++] : arrays[l2++];
    }
    while (l1 <= mid) arr[i++] = arrays[l1++];
    while (l2 <= end) arr[i++] = arrays[l2++];

    System.arraycopy(arr, 0, arrays, start, arr.length);
}
```

##### 2.3）、堆排序

默认升序，1）、构建一个大顶堆，2）、将大顶堆最大值移至最后一位，将剩余的元素继续构建一个大顶堆.


```
/**
 * 堆排序（从小到大）
 */
public void sort(int[] arr) {
    int lastIndex = arr.length - 1;

    /**
     * 构建一个大顶堆.
     */
    for (int i = parent(lastIndex); i >= 0; i--) {
        heapifyDown(arr, i, lastIndex);
    }

    /**
     * 将大顶堆最大值移至最后一位，将剩余的元素继续构建一个大顶堆.
     */
    int n = arr.length - 1;
    while (n >= 0) {
        swap(arr, 0, n);
        heapifyDown(arr, 0, n);
        n--;
    }
}

private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}

private int kthChild(int i, int k) {
    return i * 2 + k;
}

private int parent(int i) {
    return (i - 1) / 2;
}

private int maxChild(int[] arr, int i, int lastIndex) {
    int leftIndex = kthChild(i, 1);
    int rightIndex = kthChild(i, 2);
    int maxIndex = leftIndex;
    if (rightIndex < lastIndex && arr[rightIndex] > arr[leftIndex]) {
        maxIndex = rightIndex;
    }
    return maxIndex;
}

/**
 * 向下堆化. (最大堆)
 */
private void heapifyDown(int[] arr, int i, int lastIndex) {
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
```

#### 三、特殊排序算法

##### 3.1）、计数排序

计数排序不是基于比较的排序的算法，核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。时间复杂度为 O(n), 缺点是要求输入的数据必须是有范围的整数

```
public void countingSort(int[] arrays) {
    if (arrays.length <= 1) return;

    //step1、获取数组中的最大值
    int maxValue = Integer.MIN_VALUE;
    for (int num : arrays) {
        maxValue = Math.max(maxValue, num);
    }

    //step2、统计数组中数据的次数.
    int[] bucket = new int[maxValue + 1];  //index,value --> 表示对应数组中数据的个数.
    for (int num : arrays) {
        bucket[num]++;
    }

    //step3. 还原数据.
    int i = 0;
    for (int index = 0; index < bucket.length; index++) {
        while (bucket[index] > 0){
            arrays[i++] = index;
            bucket[index]--;
        }
    }
}
```


##### 3.2）、桶排序（Bucket Sort）

桶排序的工作原理：假设输入数据服从均匀分布，将数据分到优先数量的桶中，每个桶再分别排序.

```
public void bucketSort(int[] arr) {
    if (arr == null || arr.length == 0) return;

    /**
     * step1: 找出数组中的最大值，最小值
     */
    int minValue = arr[0];
    int maxValue = arr[0];
    for (int num : arr) {
        minValue = Math.min(minValue, num);
        maxValue = Math.max(maxValue, num);
    }

    /**
     * step2: 计算桶的数量，并将数据放到对应的桶中.
     */
    int bucketSize = 5;
    int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;

    Map<Integer, List<Integer>> bucket = new HashMap<>();
    for (int i = 0; i < bucketCount; i++) {
        bucket.put(i, new ArrayList<>());
    }

    for (int num : arr) {
        int bucketIndex = (int) Math.floor((num - minValue) / bucketSize);
        bucket.get(bucketIndex).add(num);
    }

    /**
     * step3: 排序每个桶.
     */
    int i = 0;
    Iterator<Integer> iterator = bucket.keySet().iterator();
    while (iterator.hasNext()) {
        int bucketIndex = iterator.next();

        List<Integer> list = bucket.get(bucketIndex);
        list.sort(Comparator.comparingInt(o -> o));

        for (Integer ele : list) {
            arr[i++] = ele;
        }
    }
}
```

##### 3.3）、基数排序（Radix Sort）

基数排序是先按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推.

```
public void radixSort(int[] arrays) {
    /**
     * 定义10个桶，每一行的行号代表第几个桶，每行对应的数据则是第几个桶对应的数.
     */
    int[][] bucket = new int[10][arrays.length];  //0 ~ 9下标的桶.

    int[] bucketIndexCounter = new int[10]; //代表每个桶有多少个元素.

    int maxValue = 0;
    for (int num : arrays) {
        maxValue = Math.max(maxValue, num);
    }

    int maxDigit = String.valueOf(maxValue).length();

    for (int i = 0, n = 1; i < maxDigit; i++, n = n * 10) {

        /**
         * 根据数位找到该数对应的桶，将其放入桶中.
         */
        for (int j = 0; j < arrays.length; j++) {
            int bucketIndex = arrays[j] / n % 10;
            bucket[bucketIndex][bucketIndexCounter[bucketIndex]++] = arrays[j];
        }

        /**
         * 依次从桶中取出，放入原数组.
         */
        int index = 0;
        for (int k = 0; k < bucketIndexCounter.length; k++) {
            int count = bucketIndexCounter[k];
            if(count == 0) continue;

            for (int j = 0; j < count; j++) {
                arrays[index++] = bucket[k][j];
            }
            bucketIndexCounter[k] = 0;
        }
    }
}
```