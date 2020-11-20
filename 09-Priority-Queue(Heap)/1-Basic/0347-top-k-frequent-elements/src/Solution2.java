import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.containsKey(nums[i]) ? countMap.get(nums[i]) + 1 : 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.count));

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            } else {
                // 偷偷看一眼堆顶的元素
                Pair heapTop = queue.peek();
                if (heapTop.count < entry.getValue()) {
                    queue.poll();
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(0, queue.poll().key);
        }

        return res;
    }

    private class Pair {
        private Integer key;
        private Integer count;

        public Pair(Integer key, Integer count) {
            this.key = key;
            this.count = count;
        }
    }
}