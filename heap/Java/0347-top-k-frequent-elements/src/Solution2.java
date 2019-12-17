import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {

    private class Pair {
        private Integer key;
        private Integer count;

        public Pair(Integer key, Integer count) {
            this.key = key;
            this.count = count;
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.containsKey(nums[i]) ? countMap.get(nums[i]) + 1 : 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.count - p2.count;
            }
        });


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

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        // [1,2]
        int k = 2;
        Solution solution = new Solution();
        List<Integer> topKFrequent = solution.topKFrequent(nums, k);
        System.out.println(topKFrequent);
    }
}
