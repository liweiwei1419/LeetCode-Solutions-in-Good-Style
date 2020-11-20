import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        // 按照频数升序排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[1]));

        Set<Map.Entry<Integer, Integer>> entries = freqs.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer num = entry.getKey();
            Integer freq = entry.getValue();

            if (minHeap.size() == k) {
                if (freq > minHeap.peek()[1]){
                    minHeap.poll();
                    minHeap.add(new int[]{num, freq});
                }
            }

            if (minHeap.size() < k) {
                minHeap.add(new int[]{num, freq});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}