
import java.util.*;

class TopKFrequent {

	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> sMap = new HashMap<>();
        /**
         * 统计元素出现的次数
         */
        for (int item : nums) {
            sMap.put(item, sMap.getOrDefault(item, 0) + 1);
        }

        //构建大顶堆.
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(sMap.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return result;
    }

}