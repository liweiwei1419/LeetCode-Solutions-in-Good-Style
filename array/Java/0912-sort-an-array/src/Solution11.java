import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/23 2:54 上午
 */
public class Solution11 {

    // 希尔排序

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;

        // 使用 Knuth 增量序列
        // 找增量的最大值
        while (3 * h + 1 < len) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // insertion sort
            for (int i = h; i < len; i++) {
                insertionForDelta(nums, h, i);
            }
            h = h / 3;
        }

        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);
        }
        return res;

    }

    /**
     * 将 arr[i] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param arr
     * @param gap
     * @param i
     */
    private void insertionForDelta(int[] arr, int gap, int i) {
        int temp = arr[i];
        int j = i;
        // 注意：这里 j >= deta 的原因
        while (j >= gap && arr[j - gap] > temp) {
            arr[j] = arr[j - gap];
            j -= gap;
        }
        arr[j] = temp;
    }
}
