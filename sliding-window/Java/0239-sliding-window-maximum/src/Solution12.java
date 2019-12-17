import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/27 6:09 上午
 */
public class Solution12 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        List<Integer> queue = new ArrayList<>(k + 1);
        for (int i = 0; i < len; i++) {
            // 考虑删除队首元素
            if (i >= k && !queue.isEmpty() && queue.get(0) == i - k) {
                queue.remove(0);
            }
            while (!queue.isEmpty() && nums[queue.get(queue.size() - 1)] < nums[i]) {
                queue.remove(queue.size() - 1);
            }
            queue.add(i);
            // 形成一个单调不减的队列，队首是滑动窗口的最大值
            // 记录结果集
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.get(0)];
            }
        }
        return res;
    }
}
