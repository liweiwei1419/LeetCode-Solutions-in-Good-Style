import java.util.ArrayList;
import java.util.List;

/**
 * 插入排序：稳定排序，在接近有序的情况下，时间复杂度最低
 */
public class Solution2 {

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        // 将 nums[i] 插入到 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0，nums[j - 1] > temp 才后移
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return arr2List(nums,len);
    }

    private List<Integer> arr2List(int[] nums, int len) {
        List<Integer> res = new ArrayList<>(len);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
}
