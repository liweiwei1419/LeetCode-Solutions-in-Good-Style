import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {

    // 常规问题：只要思路清楚，代码是很容易一遍就完成通过的。
    // 1、首先完成词频统计；
    // 2、构建一个优先队列（最小堆实现），依次往里面添加元素，
    // 3、优先队列满了的时候，就取出优先队列中的元素，与待添加的元素进行比较，比堆顶元素还大，就将堆顶元素出队，待添加元素入队。
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 这里应该组件一个最小堆，Comparator.comparingInt(Map.Entry::getValue) 这个语法是 IDEA 工具帮我完成的
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.remove();
                    queue.add(entry);
                }
            } else {
                queue.add(entry);
            }
        }

        Integer[] temp = new Integer[k];
        for (int i = k - 1; i >= 0; i--) {
            temp[i] = queue.poll().getKey();
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(temp[i]);
        }
        return result;
    }
}