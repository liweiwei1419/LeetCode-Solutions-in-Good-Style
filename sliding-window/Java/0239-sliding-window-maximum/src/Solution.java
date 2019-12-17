import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liweiwei1419
 * @date 2019/10/12 3:31 下午
 */
public class Solution {

    /**
     * 双端队列的做法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];

        // 循环不变量：
        // queue 中的元素，如果先进来的元素比后进来的元素小，先进来的元素需要从对尾弹出以后，后进来的元素才进来
        // queue 首一定是当前滑动窗口内最大元素的索引

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i >= k && queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
