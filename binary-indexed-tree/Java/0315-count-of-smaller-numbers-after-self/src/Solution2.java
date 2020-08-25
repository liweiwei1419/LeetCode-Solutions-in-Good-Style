import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }

        int[] temp = new int[len];
        int[] res = new int[len];

        // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

        // 把 int[] 转换成为 List<Integer>，没有业务逻辑
        for (int i = 0; i < len; i++) {
            result.add(res[i]);
        }
        return result;
    }

    /**
     * 针对数组 nums 指定的区间 [left, right] 进行归并排序，在排序的过程中完成统计任务
     *
     * @param nums
     * @param left
     * @param right
     */
    private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
    }

    /**
     * [left, mid] 是排好序的，[mid + 1, right] 是排好序的
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param indexes
     * @param temp
     * @param res
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > right) {
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 注意：这里是 <= ，保证稳定性
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution solution = new Solution();
        List<Integer> countSmaller = solution.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
