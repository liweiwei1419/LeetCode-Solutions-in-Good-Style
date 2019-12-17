import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/23 2:54 上午
 */
public class Solution10 {

    // 冒泡排序：超时

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            // 我们先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }

        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);
        }
        return res;
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
