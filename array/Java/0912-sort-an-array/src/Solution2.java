import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/9 4:22 下午
 */
public class Solution2 {

    // 插入排序

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        // 将 nums[i] 插入到 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            // 和 nums[j - 1] > temp 才后移，
            // 当 nums[j - 1] == temp 停止，保持稳定性
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }

        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);
        }
        return res;
    }
}
